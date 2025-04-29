package com.example.middlecourseproject.presentation.restaurant.event

sealed class RestaurantEvent {
    data object LoadCategories : RestaurantEvent()
    data object LoadAllRestaurants : RestaurantEvent()
    data object LoadAdBanners : RestaurantEvent()
    data class CategorySelected(val categoryId: String) : RestaurantEvent()
    data class RestaurantSelected(val restaurantId: String) : RestaurantEvent()
    data class AdBannerSelected(val adId: String) : RestaurantEvent()
    data class LocationUpdated(
        val latitude: Double,
        val longitude: Double,
        val address: String? = null
    ) : RestaurantEvent()
    data object NotificationPermissionGranted : RestaurantEvent()
    data object NotificationPermissionDenied : RestaurantEvent()
}