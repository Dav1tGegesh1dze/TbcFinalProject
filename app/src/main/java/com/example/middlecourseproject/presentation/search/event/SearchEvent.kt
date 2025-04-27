package com.example.middlecourseproject.presentation.search.event

sealed class SearchEvent {
    data object LoadPopularSearches : SearchEvent()
    data object LoadAllRestaurants : SearchEvent()
    data class Search(val query: String) : SearchEvent()
    data class RestaurantSelected(val restaurantId: String) : SearchEvent()
    data object ClearSearch : SearchEvent()
    data object ErrorShown : SearchEvent()
}