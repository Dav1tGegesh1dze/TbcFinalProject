package com.example.middlecourseproject.presentation.restaurant.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.middlecourseproject.databinding.FragmentRestaurantBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.restaurant.adapter.CategoryAdapter
import com.example.middlecourseproject.presentation.restaurant.adapter.RestaurantAdapter
import com.example.middlecourseproject.presentation.restaurant.event.RestaurantEvent
import com.example.middlecourseproject.presentation.restaurant.viewmodel.RestaurantViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RestaurantFragment : BaseFragment<FragmentRestaurantBinding>(
    FragmentRestaurantBinding::inflate
) {

    private val viewModel: RestaurantViewModel by viewModels()

    private val categoryAdapter = CategoryAdapter { categoryId ->
        viewModel.onEvent(RestaurantEvent.CategorySelected(categoryId))
    }

    private val restaurantAdapter = RestaurantAdapter { restaurantId ->
        viewModel.onEvent(RestaurantEvent.RestaurantSelected(restaurantId))
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    // Permission
    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                getLocationAndUpdate()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                getLocationAndUpdate()
            }
            else -> {
                Toast.makeText(
                    requireContext(),
                    "Location permission denied. Using default location.",
                    Toast.LENGTH_SHORT
                ).show()

                // If user is denied ,we go to bottom sheet
                showLocationBottomSheet()
            }
        }
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // success notification
            viewModel.onEvent(RestaurantEvent.NotificationPermissionGranted)
        } else {
            viewModel.onEvent(RestaurantEvent.NotificationPermissionDenied)
            Toast.makeText(
                requireContext(),
                "Without notification permission, you won't receive order updates.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            checkNotificationPermission()
        }
    }

    override fun start() {
        setupRecyclerViews()
        observeState()
        setupLocationBar()

        viewModel.onEvent(RestaurantEvent.LoadCategories)
        viewModel.onEvent(RestaurantEvent.LoadAllRestaurants)
    }

    private fun setupRecyclerViews() {
        binding.rvCategories.adapter = categoryAdapter
        binding.rvRestaurants.adapter = restaurantAdapter
    }

    private fun setupLocationBar() {
        binding.locationBar.setOnClickListener {
            showLocationBottomSheet()
        }

        if (hasLocationPermission()) {
            getLocationAndUpdate()
        } else {

            binding.tvLocation.text = "Select location"
        }
    }

    private fun showLocationBottomSheet() {
        val bottomSheet = LocationBottomSheetFragment()
        bottomSheet.setOnLocationSelectedListener { latitude, longitude, address ->
            updateLocationDisplay(latitude, longitude, address)
        }
        bottomSheet.setOnCurrentLocationRequestedListener {
            requestLocationPermission()
        }
        bottomSheet.show(childFragmentManager, LocationBottomSheetFragment.TAG)
    }

    private fun updateLocationDisplay(latitude: Double, longitude: Double, address: String?) {
        val displayText = address ?: "${String.format("%.5f", latitude)}°N ${String.format("%.5f", longitude)}°E"
        binding.tvLocation.text = displayText
        viewModel.onEvent(RestaurantEvent.LocationUpdated(latitude, longitude, address))
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        when {
            hasLocationPermission() -> {
                getLocationAndUpdate()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                showLocationPermissionRationale()
            }
            else -> {
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }

    private fun showLocationPermissionRationale() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Location Permission Required")
            .setMessage("We need access to your location to show nearby restaurants and provide accurate delivery estimates.")
            .setPositiveButton("Grant Permission") { _, _ ->
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
            .setNegativeButton("No Thanks") { _, _ ->
                showLocationBottomSheet()
            }
            .show()
    }

    @SuppressLint("MissingPermission")
    private fun getLocationAndUpdate() {
        if (!hasLocationPermission()) {
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                location?.let {
                    updateLocationDisplay(it.latitude, it.longitude, null)
                } ?: run {
                    Toast.makeText(
                        requireContext(),
                        "Couldn't get current location. Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    requireContext(),
                    "Error getting location: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    viewModel.onEvent(RestaurantEvent.NotificationPermissionGranted)
                }
                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                    showNotificationPermissionRationale()
                }
                else -> {
                    notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            // For Android versions below 13, notification permission is granted by default
            viewModel.onEvent(RestaurantEvent.NotificationPermissionGranted)
        }
    }

    private fun showNotificationPermissionRationale() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Notification Permission Required")
            .setMessage("We need to send you notifications for order updates, delivery status, and special offers.")
            .setPositiveButton("Grant Permission") { _, _ ->
                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
            .setNegativeButton("No Thanks") { _, _ ->
                viewModel.onEvent(RestaurantEvent.NotificationPermissionDenied)
            }
            .show()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                // Update UI
                binding.progressBar.isVisible = state.isLoading

                // Update adapters
                categoryAdapter.submitList(state.categories)
                categoryAdapter.setSelectedCategory(state.selectedCategoryId)
                restaurantAdapter.submitList(state.restaurants)

                // Rrrors handlong
                state.error?.let { errorMessage ->
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }

                // Update location
                if (state.userLatitude != null && state.userLongitude != null) {
                    val displayText = state.userAddress ?:
                    "${String.format("%.5f", state.userLatitude)}°N ${String.format("%.5f", state.userLongitude)}°E"
                    binding.tvLocation.text = displayText
                }
            }
        }
    }
}
