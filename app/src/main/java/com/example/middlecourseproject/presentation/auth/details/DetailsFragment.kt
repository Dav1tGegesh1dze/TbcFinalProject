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
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
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
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.Calendar

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModels()

    // Data for spinners.
    private val genderList = listOf("male" to 1, "female" to 2)
    private val cityList = listOf("თბილისი" to 1, "ქუთაისი" to 2, "ბათუმი" to 3, "თელავი" to 4, "მცხეთა" to 5)
    private val nationalityList = listOf("საქართველო" to 1, "გერმანია" to 2, "სლოვაკეთი" to 3, "დანია" to 4, "ჩინეთი" to 5)

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
        // Gender spinner
        val genderAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            genderList.map { it.first }
        )
        binding.genderSpinner.adapter = genderAdapter
        binding.genderSpinner.setSelection(-1)
        binding.genderSpinner.setOnItemSelectedListener { index ->
            selectedGenderId = genderList[index].second
        }
        // City spinner
        val cityAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            cityList.map { it.first }
        )
        binding.citySpinner.adapter = cityAdapter
        binding.citySpinner.setSelection(-1)
        binding.citySpinner.setOnItemSelectedListener { index ->
            selectedCityId = cityList[index].second
        }
        // Nationality spinner
        val nationAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            nationalityList.map { it.first }
        )
        binding.nationalitySpinner.adapter = nationAdapter
        binding.nationalitySpinner.setSelection(-1)
        binding.nationalitySpinner.setOnItemSelectedListener { index ->
            selectedNationalityId = nationalityList[index].second
        }
    }

    private fun Spinner.setOnItemSelectedListener(onItemSelected: (position: Int) -> Unit) {
        this.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                onItemSelected(position)
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
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
        uri?.let { convertUriToBase64(it) }
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
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        } else {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(cameraIntent)
        }
    }

    // Permission launcher for camera access.
    private val requestCameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(cameraIntent)
        } else {
            showError("Camera permission was denied")
        }
    }

    private fun convertUriToBase64(uri: Uri) {
        val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
        updateProfileImage(bitmap)
    }

    private fun updateProfileImage(bitmap: Bitmap) {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
        profilePhotoBase64 = Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
        binding.profileImage.setImageBitmap(bitmap)
        println(profilePhotoBase64)
    }

    private fun onSaveClicked() {
        val firstName = binding.firstNameInput.text.toString().trim()
        val lastName = binding.lastNameInput.text.toString().trim()
        val birthDate = binding.birthDateInput.text.toString().trim()
        if (selectedGenderId == null || selectedCityId == null || selectedNationalityId == null) {
            showError("Please select gender, city, and nationality")
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
        // Observe persistent loading state.
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
                    is DetailsEvent.Error -> showError(event.message)
                    else -> {}
                }
            }
        }
    }

    private fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}
