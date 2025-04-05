package com.example.middlecourseproject.domain.restaurant.usecase

import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantsByCategoryUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(categoryId: String? = null): Flow<List<Restaurant>> {
        return repository.getRestaurantsByCategory(categoryId)
    }
}