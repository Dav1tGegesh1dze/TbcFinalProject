package com.example.middlecourseproject.presentation.restaurant.event

sealed class RestaurantEvent {
    data object LoadCategories : RestaurantEvent()
    data object LoadAllRestaurants : RestaurantEvent()
    data class CategorySelected(val categoryId: String) : RestaurantEvent()
    data class RestaurantSelected(val restaurantId: String) : RestaurantEvent()
}