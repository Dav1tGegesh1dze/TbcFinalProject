package com.example.middlecourseproject.presentation.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Base64
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.databinding.FragmentProfileBinding
import com.example.middlecourseproject.domain.models.Profile
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.convertUriToBase64
import com.example.middlecourseproject.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels()
    @Inject
    lateinit var imageLoader: com.example.middlecourseproject.domain.imageLoading.ImageLoader

    // Flag to track whether we are in edit mode.
    private var isEditing = false
    // Holds the new image in Base64 if user selects a new image.
    private var newProfilePhotoBase64: String? = null

    override fun start() {
        // Fetch profile info on start.
        profileViewModel.fetchProfile()
        observeProfile()
        observeUpdateEvent()
        setupLogoutButton()
        goBack()
        observeLogoutState()
        binding.editButton.setOnClickListener { toggleEditMode() }
    }

    private fun setProfile(data: Profile) {
        // Always update the profile image.
        if (!isEditing) {
            // In non-edit mode, update the text fields from the profile.
            binding.firstName.setText(data.firstName)
            binding.lastName.setText(data.lastName)
        }
        // If not in edit mode or if there is no new image, show the profile image from data.
        // (You could also choose to always update the image if it changes.)
        data.profilePhotoUrl?.let {
            imageLoader.loadImage(binding.profileImage, it)
        } ?: run {
            binding.profileImage.setImageResource(R.drawable.avatari1)
        }
    }

    // Toggle edit mode: enable editing fields and update UI.
    private fun toggleEditMode() {
        isEditing = !isEditing
        if (isEditing) {
            // Enter edit mode: enable EditTexts and make profile image clickable.
            binding.firstName.isEnabled = true
            binding.lastName.isEnabled = true
            binding.profileImage.isClickable = true
            // Change the edit button icon to "done" (assume you have drawable for done).
            binding.editButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_done_24, 0, 0, 0)
            // Set profile image click listener to allow image change.
            binding.profileImage.setOnClickListener { showImageOptions() }
        } else {
            // Exit edit mode: disable editing and reset click listeners.
            binding.firstName.isEnabled = false
            binding.lastName.isEnabled = false
            binding.profileImage.isClickable = false
            // Change icon back to edit.
            binding.editButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_edit_24, 0, 0, 0)
            // Trigger update API.
            updateProfile()
        }
    }

    // Show image options (pick from gallery or take photo) if in edit mode.
    private fun showImageOptions() {
        val options = arrayOf(
            getString(R.string.pick_from_gallery),
            getString(R.string.take_photo),
            getString(R.string.cancel)
        )
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.select_image))
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> pickFromGallery()
                    1 -> takePhoto()
                    2 -> dialog.dismiss()
                }
            }.show()
    }

    // Launcher to pick image from gallery.
    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            newProfilePhotoBase64 = requireContext().convertUriToBase64(it)
            binding.profileImage.setImageURI(it)
        }
    }

    private fun pickFromGallery() {
        galleryLauncher.launch("image/*")
    }

    // Launcher for taking a photo.
    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? android.graphics.Bitmap
            bitmap?.let { updateProfileImage(it) }
        }
    }

    private fun takePhoto() {
        when {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                launchCamera()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                showPermissionRationaleDialog()
            }
            else -> {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun showPermissionRationaleDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.camera_permission_required))
            .setMessage(getString(R.string.camera_permission_message))
            .setPositiveButton(getString(R.string.go_to_settings)) { dialog, _ ->
                dialog.dismiss()
                val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", requireContext().packageName, null)
                }
                startActivity(intent)
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    // Permission launcher for camera.
    private val requestCameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            launchCamera()
        } else {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                showPermissionRationaleDialog()
            } else {
                binding.root.showSnackbar(getString(R.string.camera_permission_denied))
            }
        }
    }

    private fun launchCamera() {
        val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(cameraIntent)
    }

    private fun updateProfileImage(bitmap: android.graphics.Bitmap) {
        val outputStream = java.io.ByteArrayOutputStream()
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, outputStream)
        newProfilePhotoBase64 = Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
        binding.profileImage.setImageBitmap(bitmap)
    }

    // Update profile with the new first and last names and new image (if changed).
    private fun updateProfile() {
        val newFirstName = binding.firstName.text.toString().trim()
        val newLastName = binding.lastName.text.toString().trim()
        // Call ViewModel update. Fields not editable (gender, birthDate, etc.) are taken from the fetched profile.
        profileViewModel.updateProfile(newFirstName, newLastName, newProfilePhotoBase64)
    }

    private fun observeProfile() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.profile.collect { resource ->
                    when (resource) {
                        is Resource.Idle -> binding.progressBar.visibility = View.GONE
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            if (!isEditing) {
                                setProfile(resource.data)
                            } else {
                                // If editing, update only the profile image (if needed)
                                resource.data.profilePhotoUrl?.let {
                                    imageLoader.loadImage(binding.profileImage, it)
                                } ?: binding.profileImage.setImageResource(R.drawable.avatari1)
                            }
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.root.showSnackbar(resource.message)
                        }
                    }
                }
            }
        }
    }

    private fun observeUpdateEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.updateEvent.collect { event ->
                    when (event) {
                        is UpdateEvent.Success -> {
                            binding.root.showSnackbar(getString(R.string.profile_update_successfully))
                            // Optionally exit edit mode if not already done.
                        }
                        is UpdateEvent.Error -> {
                            binding.root.showSnackbar(event.message)
                        }
                    }
                }
            }
        }
    }
    private fun observeLogoutState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.logoutState.collect { state ->
                    when (state) {
                        is Resource.Idle ->{
                            binding.logOut.text = getString(R.string.log_out)
                            binding.logOut.isEnabled = true
                        }
                        is Resource.Loading -> {
                            binding.logOut.text = getString(R.string.loading)
                            binding.logOut.isEnabled = false
                        }
                        is Resource.Success -> {
                            binding.logOut.text = getString(R.string.log_out)
                            binding.logOut.isEnabled = true
                            navigateToLogin()
                        }
                        is Resource.Error -> {
                            binding.logOut.text = getString(R.string.log_out)
                            binding.logOut.isEnabled = true
                            binding.root.showSnackbar(state.message)
                        }

                    }
                }
            }
        }
    }
    private fun navigateToLogin() {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.home2, true)
            .build()
        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToLoginFragment(),navOptions)
    }
    private fun goBack() {
        binding.goBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupLogoutButton() {
        binding.logOut.setOnClickListener {
            profileViewModel.logout()
        }
    }
}
