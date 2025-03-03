// DetailsFragment.kt
package com.example.middlecourseproject.presentation.auth.details


import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentDetailsBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.convertUriToBase64
import com.example.middlecourseproject.utils.onItemSelected
import com.example.middlecourseproject.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.Calendar

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModels()

    // Selected IDs from spinners.
    private var selectedGenderId: Int? = null
    private var selectedCityId: Int? = null
    private var selectedNationalityId: Int? = null

    // Base64 string for the chosen/taken photo.
    private var profilePhotoBase64: String? = null

    override fun start() {
        setupSpinners()
        setupBirthDatePicker()
        setupProfileImageClick()
        observeViewModel()
        binding.saveButton.setOnClickListener { onSaveClicked() }
    }

    private fun setupSpinners() {
        // Gender spinner setup
        val genderAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.genderList.map { it.first }
        )
        binding.genderSpinner.adapter = genderAdapter
        binding.genderSpinner.setSelection(-1)
        binding.genderSpinner.onItemSelected { position ->
            selectedGenderId = detailsViewModel.genderList[position].second
        }
        // City spinner setup
        val cityAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.cityList.map { it.first }
        )
        binding.citySpinner.adapter = cityAdapter
        binding.citySpinner.setSelection(-1)
        binding.citySpinner.onItemSelected { position ->
            selectedCityId = detailsViewModel.cityList[position].second
        }
        // Nationality spinner setup
        val nationAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.nationalityList.map { it.first }
        )
        binding.nationalitySpinner.adapter = nationAdapter
        binding.nationalitySpinner.setSelection(-1)
        binding.nationalitySpinner.onItemSelected { position ->
            selectedNationalityId = detailsViewModel.nationalityList[position].second
        }
    }

    private fun setupBirthDatePicker() {
        binding.birthDateInput.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                requireContext(),
                { _: DatePicker, y: Int, m: Int, d: Int ->
                    val mm = (m + 1).toString().padStart(2, '0')
                    val dd = d.toString().padStart(2, '0')
                    binding.birthDateInput.setText("$y-$mm-$dd")
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setupProfileImageClick() {
        binding.profileImage.setOnClickListener {
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
    }

    // Launcher to pick image from gallery.
    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            // Use extension function on context to convert URI.
            profilePhotoBase64 = requireContext().convertUriToBase64(it)
            // Optionally update the image view.
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
            val bitmap = result.data?.extras?.get("data") as? Bitmap
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

    // Permission launcher for camera access.
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
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(cameraIntent)
    }

    private fun updateProfileImage(bitmap: Bitmap) {
        // Convert bitmap to Base64 string.
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
        profilePhotoBase64 = Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
        // Update the UI.
        binding.profileImage.setImageBitmap(bitmap)
    }

    private fun onSaveClicked() {
        val firstName = binding.firstNameInput.text.toString().trim()
        val lastName = binding.lastNameInput.text.toString().trim()
        val birthDate = binding.birthDateInput.text.toString().trim()
        if (selectedGenderId == null || selectedCityId == null || selectedNationalityId == null) {
            binding.root.showSnackbar("Please select gender, city, and nationality")
            return
        }
        detailsViewModel.updateDetails(
            firstName = firstName,
            lastName = lastName,
            genderId = selectedGenderId!!,
            birthDate = birthDate,
            cityId = selectedCityId!!,
            nationalityId = selectedNationalityId!!,
            profilePhotoBase64 = profilePhotoBase64
        )
    }

    private fun observeViewModel() {
        // Observe loading state.
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailsViewModel.loading.collect { isLoading ->
                    if (isLoading) {
                        binding.saveButton.isEnabled = false
                        binding.detailsButtonLoader.visibility = View.VISIBLE
                        binding.saveButton.text = ""
                    } else {
                        binding.saveButton.isEnabled = true
                        binding.detailsButtonLoader.visibility = View.GONE
                        binding.saveButton.setText(R.string.save)
                    }
                }
            }
        }
        // Observe one-time events.
        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.detailsEvent.collect { event ->
                when (event) {
                    is DetailsEvent.Success -> {
                        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHome2())
                    }
                    is DetailsEvent.Error -> binding.root.showSnackbar(event.message)
                }
            }
        }
    }
}
