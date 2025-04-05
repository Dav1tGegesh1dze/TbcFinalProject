package com.example.middlecourseproject.domain.restaurant.repository

import com.example.middlecourseproject.domain.restaurant.model.Category
import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getCategories(): Flow<List<Category>>
    fun getRestaurantsByCategory(categoryId: String?): Flow<List<Restaurant>>
    fun getAllRestaurants(): Flow<List<Restaurant>>
}