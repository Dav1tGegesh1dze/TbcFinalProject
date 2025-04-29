package com.example.middlecourseproject.domain.search.usecase

import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import com.example.middlecourseproject.domain.search.SearchHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
    private val searchHelper: SearchHelper
) {

    fun getPopularSearchTerms(): Flow<List<String>> {
        return restaurantRepository.getAllRestaurants()
            .map { restaurants ->
                searchHelper.generatePopularSearchTerms(restaurants)
            }
    }

    fun searchRestaurants(query: String): Flow<List<Restaurant>> {
        return restaurantRepository.getAllRestaurants()
            .map { restaurants ->
                if (query.isBlank()) {
                    emptyList()
                } else {
                    searchHelper.filterRestaurants(restaurants, query)
                }
            }
    }
}