package com.example.middlecourseproject.presentation.restaurant.state

import com.example.middlecourseproject.domain.restaurant.model.Category
import com.example.middlecourseproject.domain.restaurant.model.Restaurant

data class RestaurantState(
    val categories: List<Category> = emptyList(),
    val restaurants: List<Restaurant> = emptyList(),
    val selectedCategoryId: String? = null,
    val userLatitude: Double? = null,
    val userLongitude: Double? = null,
    val userAddress: String? = null,
    val notificationsEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)