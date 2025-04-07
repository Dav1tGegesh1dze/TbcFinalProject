package com.example.middlecourseproject.domain.restaurant.usecase

import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRestaurantByIdUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(restaurantId: String): Flow<Restaurant> {
        return repository.getAllRestaurants()
            .map { restaurants ->
                restaurants.find { it.id == restaurantId }
                    ?: throw NoSuchElementException("Restaurant with ID $restaurantId not found")
            }
    }
}