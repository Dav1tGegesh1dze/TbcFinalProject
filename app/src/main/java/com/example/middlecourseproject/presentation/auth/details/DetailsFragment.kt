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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentDetailsBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.convertUriToBase64
import com.example.middlecourseproject.utils.onItemSelected
import com.example.middlecourseproject.utils.showSnackbar
import com.example.middlecourseproject.utils.toBase64
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.Calendar

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModels()

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val base64 = requireContext().convertUriToBase64(it)
            if (base64!!.isNotEmpty()) {
                detailsViewModel.processIntent(DetailsIntent.UpdateProfilePhoto(base64))
            } else {
                binding.root.showSnackbar("Failed to process image")
            }
        }
    }

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                val base64 = it.toBase64()
                if (base64.isNotEmpty()) {
                    detailsViewModel.processIntent(DetailsIntent.UpdateProfilePhoto(base64))
                    binding.profileImage.setImageBitmap(it)
                } else {
                    binding.root.showSnackbar("Failed to process image")
                }
            }
        }
    }

    private val requestCameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            launchCamera()
        } else {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                detailsViewModel.processIntent(DetailsIntent.RequestCameraPermission)
            } else {
                binding.root.showSnackbar(getString(R.string.camera_permission_denied))
            }
        }
    }

    override fun start() {
        setupSpinners()
        setupBirthDatePicker()
        setupProfileImageClick()
        setupListeners()
        observeState()
        observeSideEffects()
    }

    private fun setupSpinners() {
        val genderAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.genderList.map { it.first }
        )
        binding.genderSpinner.adapter = genderAdapter
        binding.genderSpinner.onItemSelected(onItemSelected = { position ->
            detailsViewModel.processIntent(DetailsIntent.UpdateGender(detailsViewModel.genderList[position].second))
        })

        val cityAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.cityList.map { it.first }
        )
        binding.citySpinner.adapter = cityAdapter
        binding.citySpinner.onItemSelected(onItemSelected = { position ->
            detailsViewModel.processIntent(DetailsIntent.UpdateCity(detailsViewModel.cityList[position].second))
        })

        val nationAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            detailsViewModel.nationalityList.map { it.first }
        )
        binding.nationalitySpinner.adapter = nationAdapter
        binding.nationalitySpinner.onItemSelected(onItemSelected = { position ->
            detailsViewModel.processIntent(DetailsIntent.UpdateNationality(detailsViewModel.nationalityList[position].second))
        })
    }

    private fun setupBirthDatePicker() {
        binding.birthDateInput.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    val mm = (month + 1).toString().padStart(2, '0')
                    val dd = day.toString().padStart(2, '0')
                    val date = "$year-$mm-$dd"
                    detailsViewModel.processIntent(DetailsIntent.UpdateBirthDate(date))
                    binding.birthDateInput.setText(date)
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
                        0 -> detailsViewModel.processIntent(DetailsIntent.PickImageFromGallery)
                        1 -> detailsViewModel.processIntent(DetailsIntent.TakePhoto)
                        2 -> dialog.dismiss()
                    }
                }.show()
        }
    }

    private fun setupListeners() {
        binding.firstNameInput.addTextChangedListener { text ->
            detailsViewModel.processIntent(DetailsIntent.UpdateFirstName(text.toString()))
        }
        binding.lastNameInput.addTextChangedListener { text ->
            detailsViewModel.processIntent(DetailsIntent.UpdateLastName(text.toString()))
        }
        binding.saveButton.setOnClickListener {
            detailsViewModel.processIntent(DetailsIntent.SaveDetails)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.state.collect { state ->
                binding.firstNameInput.error = state.firstNameError
                binding.lastNameInput.error = state.lastNameError
                binding.birthDateInput.error = state.birthDateError
                if (state.genderError != null) binding.genderSpinner.tag = state.genderError
                if (state.cityError != null) binding.citySpinner.tag = state.cityError
                if (state.nationalityError != null) binding.nationalitySpinner.tag = state.nationalityError

                if (state.isLoading) {
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

    private fun observeSideEffects() {
        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is DetailsSideEffect.ShowError -> binding.root.showSnackbar(effect.message)
                    is DetailsSideEffect.NavigateToHome -> {
                        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHome2())
                    }
                    is DetailsSideEffect.LaunchGalleryPicker -> galleryLauncher.launch("image/*")
                    is DetailsSideEffect.LaunchCamera -> launchCamera()
                    is DetailsSideEffect.ShowCameraPermissionRationale -> showPermissionRationaleDialog()
                    is DetailsSideEffect.ShowCameraPermissionDenied -> {
                        binding.root.showSnackbar(getString(R.string.camera_permission_denied))
                    }
                }
            }
        }
    }

    private fun launchCamera() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(cameraIntent)
        } else {
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun showPermissionRationaleDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.camera_permission_required))
            .setMessage(getString(R.string.camera_permission_message))
            .setPositiveButton(getString(R.string.go_to_settings)) { _, _ ->
                val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", requireContext().packageName, null)
                }
                startActivity(intent)
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}