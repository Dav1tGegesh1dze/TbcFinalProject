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
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.databinding.FragmentProfileBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.imageLoading.ImageLoader
import com.example.middlecourseproject.presentation.models.Profile
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.utils.convertUriToBase64
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels()
    @Inject
    lateinit var imageLoader: ImageLoader

    private var isEditing = false
    private var newProfilePhotoBase64: String? = null

    @Inject
    lateinit var errorMapper: ErrorMapper

    override fun start() {
        profileViewModel.fetchProfile()
        observeProfile()
        observeUpdateEvent()
        setupLogoutButton()
        goBack()
        observeLogoutState()
        binding.editButton.setOnClickListener { toggleEditMode() }
    }

    private fun setProfile(data: Profile) {
        if (!isEditing) {
            binding.firstName.setText(data.firstName)
            binding.lastName.setText(data.lastName)
        }

        data.profilePhotoUrl?.let {
            imageLoader.loadImage(binding.profileImage, it)
        } ?: run {
            binding.profileImage.setImageResource(R.drawable.avatari1)
        }
    }

    private fun toggleEditMode() {
        isEditing = !isEditing
        if (isEditing) {
            binding.firstName.isEnabled = true
            binding.lastName.isEnabled = true
            binding.profileImage.isClickable = true
            binding.editButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_done_24, 0, 0, 0)
            binding.profileImage.setOnClickListener { showImageOptions() }
        } else {
            binding.firstName.isEnabled = false
            binding.lastName.isEnabled = false
            binding.profileImage.isClickable = false
            binding.editButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_edit_24, 0, 0, 0)
            updateProfile()
        }
    }

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

    private fun updateProfile() {
        val newFirstName = binding.firstName.text.toString().trim()
        val newLastName = binding.lastName.text.toString().trim()
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
                                resource.data.profilePhotoUrl?.let {
                                    imageLoader.loadImage(binding.profileImage, it)
                                } ?: binding.profileImage.setImageResource(R.drawable.avatari1)
                            }
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            val errorMessage = errorMapper.mapToMessage(resource.message)

                            binding.root.showSnackbar(errorMessage)
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
                            val errorMessage = errorMapper.mapToMessage(state.message)
                            binding.root.showSnackbar(errorMessage)
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
