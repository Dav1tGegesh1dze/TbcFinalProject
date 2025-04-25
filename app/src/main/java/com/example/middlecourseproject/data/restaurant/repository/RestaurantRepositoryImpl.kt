package com.example.middlecourseproject.data.restaurant.repository

import com.example.middlecourseproject.data.restaurant.api.RestaurantApi
import com.example.middlecourseproject.data.restaurant.model.mappers.extractCategories
import com.example.middlecourseproject.data.restaurant.model.mappers.toDomain
import com.example.middlecourseproject.domain.restaurant.model.AdBanner
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

    override fun getAdBanners(): Flow<List<AdBanner>> = flow {
        try {
            val response = restaurantApi.getAdBanners()
            val adBanners = response.adBanners.map { it.toDomain() }
            emit(adBanners)
        } catch (e: Exception) {
            // Fallback to mock data if API fails
            val fallbackBanners = createFallbackAdBanners()
            emit(fallbackBanners)
        }
    }

    private fun createFallbackAdBanners(): List<AdBanner> {
        // This is just a fallback if the API call fails
        return listOf(
            AdBanner(
                id = "fallback_1",
                title = "Special Offers",
                description = "Check out our latest promotions",
                mediaType = "image",
                mediaUrl = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5",
                actionType = "none",
                actionTarget = ""
            )
        )
    }
}