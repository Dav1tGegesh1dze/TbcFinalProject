package com.example.middlecourseproject.presentation.search.state

import com.example.middlecourseproject.domain.restaurant.model.Restaurant

data class SearchState(
    val searchQuery: String = "",
    val popularSearches: List<String> = emptyList(),
    val allRestaurants: List<Restaurant> = emptyList(),
    val searchResults: List<Restaurant> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)