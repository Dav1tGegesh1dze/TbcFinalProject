package com.example.middlecourseproject.presentation.restaurant.state

import com.example.middlecourseproject.domain.restaurant.model.Restaurant

data class DishesState(
    val restaurant: Restaurant? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)