package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.AdBannersResponse
import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("75dae8de-55a0-4288-a574-bc91a9be52e2")
    suspend fun getRestaurants(): List<RestaurantDto>

    @GET("7aefc786-1e06-4b6c-87a6-20c1ba7a947f")
    suspend fun getAdBanners(): AdBannersResponse
}