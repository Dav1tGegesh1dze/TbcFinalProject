package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("97e3ea02-bc6a-486c-8553-21567546b4f2")
    suspend fun getRestaurants(): List<RestaurantDto>
}