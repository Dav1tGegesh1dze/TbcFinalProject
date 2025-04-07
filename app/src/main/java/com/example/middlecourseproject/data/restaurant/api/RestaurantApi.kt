package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("5f41fc35-a4bf-49aa-b09d-95d68f755bb6")
    suspend fun getRestaurants(): List<RestaurantDto>
}