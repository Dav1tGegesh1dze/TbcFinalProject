package com.example.middlecourseproject.presentation.restaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.restaurant.usecase.GetAdBannersUseCase
import com.example.middlecourseproject.domain.restaurant.usecase.GetCategoriesUseCase
import com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase
import com.example.middlecourseproject.presentation.restaurant.event.RestaurantEvent
import com.example.middlecourseproject.presentation.restaurant.state.RestaurantState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getRestaurantsByCategoryUseCase: GetRestaurantsByCategoryUseCase,
    private val getAdBannersUseCase: GetAdBannersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RestaurantState())
    val state: StateFlow<RestaurantState> = _state

    init {
        onEvent(RestaurantEvent.LoadCategories)
        onEvent(RestaurantEvent.LoadAllRestaurants)
        onEvent(RestaurantEvent.LoadAdBanners)
    }

    fun onEvent(event: RestaurantEvent) {
        when (event) {
            is RestaurantEvent.LoadCategories -> {
                loadCategories()
            }

            is RestaurantEvent.LoadAllRestaurants -> {
                loadRestaurants(null)
            }

            is RestaurantEvent.LoadAdBanners -> {
                loadAdBanners()
            }

            is RestaurantEvent.CategorySelected -> {
                _state.update { it.copy(selectedCategoryId = event.categoryId) }
                loadRestaurants(event.categoryId)
            }

            is RestaurantEvent.RestaurantSelected -> {
                // Future implementation
            }

            is RestaurantEvent.AdBannerSelected -> {
                // Handle ad banner click here
                val adBanner = _state.value.adBanners.find { it.id == event.adId }
                adBanner?.let { banner ->
                    when (banner.actionType) {
                        "restaurant" -> {
                            // If the action type is restaurant, we can use the actionTarget as restaurantId
                            val restaurantId = banner.actionTarget
                            // Future implementation: Navigate to restaurant details
                        }
                        // Handle other action types as needed
                    }
                }
            }

            is RestaurantEvent.LocationUpdated -> {
                _state.update {
                    it.copy(
                        userLatitude = event.latitude,
                        userLongitude = event.longitude,
                        userAddress = event.address
                    )
                }
                loadNearbyRestaurants(event.latitude, event.longitude)
            }

            is RestaurantEvent.NotificationPermissionGranted -> {
                _state.update { it.copy(notificationsEnabled = true) }
            }

            is RestaurantEvent.NotificationPermissionDenied -> {
                _state.update { it.copy(notificationsEnabled = false) }
            }
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            getCategoriesUseCase()
                .onEach { categories ->
                    _state.update { it.copy(categories = categories, isLoading = false) }
                }
                .catch { error ->
                    _state.update { it.copy(error = error.message, isLoading = false) }
                }
                .launchIn(this)
        }
    }

    private fun loadAdBanners() {
        viewModelScope.launch {
            getAdBannersUseCase()
                .onEach { adBanners ->
                    _state.update { it.copy(adBanners = adBanners) }
                }
                .catch { error ->
                    _state.update { it.copy(error = error.message) }
                }
                .launchIn(this)
        }
    }

    private fun loadRestaurants(categoryId: String?) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            getRestaurantsByCategoryUseCase(categoryId)
                .onEach { restaurants ->
                    _state.update { it.copy(restaurants = restaurants, isLoading = false) }
                }
                .catch { error ->
                    _state.update { it.copy(error = error.message, isLoading = false) }
                }
                .launchIn(this)
        }
    }

    private fun loadNearbyRestaurants(latitude: Double, longitude: Double) {
        // Future functionality - can be implemented later to filter restaurants by location
        loadRestaurants(state.value.selectedCategoryId)
    }
}