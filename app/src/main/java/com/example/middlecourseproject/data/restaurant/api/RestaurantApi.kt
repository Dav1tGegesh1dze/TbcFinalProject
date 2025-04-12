package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("93a9dc7d-2863-4849-90a6-355b2d0bf092")
    suspend fun getRestaurants(): List<RestaurantDto>
}