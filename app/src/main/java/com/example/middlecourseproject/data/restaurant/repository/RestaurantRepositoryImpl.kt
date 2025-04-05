package com.example.middlecourseproject.data.restaurant.repository

import com.example.middlecourseproject.data.restaurant.api.RestaurantApi
import com.example.middlecourseproject.data.restaurant.model.mappers.extractCategories
import com.example.middlecourseproject.data.restaurant.model.mappers.toDomain
import com.example.middlecourseproject.domain.restaurant.model.Category
import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val restaurantApi: RestaurantApi
) : RestaurantRepository {

    override fun getCategories(): Flow<List<Category>> = flow {
        val restaurantsDto = restaurantApi.getRestaurants()
        val categories = restaurantsDto.extractCategories()
        emit(categories)
    }

    override fun getRestaurantsByCategory(categoryId: String?): Flow<List<Restaurant>> = flow {
        val restaurantsDto = restaurantApi.getRestaurants()
        val restaurants = restaurantsDto.map { it.toDomain() }

        if (categoryId != null) {
            emit(restaurants.filter { it.categoryId == categoryId })
        } else {
            emit(restaurants)
        }
    }

    override fun getAllRestaurants(): Flow<List<Restaurant>> = flow {
        val restaurantsDto = restaurantApi.getRestaurants()
        val restaurants = restaurantsDto.map { it.toDomain() }
        emit(restaurants)
    }
}