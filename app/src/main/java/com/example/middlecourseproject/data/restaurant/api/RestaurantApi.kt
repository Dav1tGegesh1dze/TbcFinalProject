package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("7f7056d3-7356-4426-8790-2fa1b27ff883")
    suspend fun getRestaurants(): List<RestaurantDto>
}