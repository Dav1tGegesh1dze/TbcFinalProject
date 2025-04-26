package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.AdBannersResponse
import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("75dae8de-55a0-4288-a574-bc91a9be52e2")
    suspend fun getRestaurants(): List<RestaurantDto>

    @GET("1a8ccfa6-99d0-4b7b-81f5-9465eb64f871")
    suspend fun getAdBanners(): AdBannersResponse
}