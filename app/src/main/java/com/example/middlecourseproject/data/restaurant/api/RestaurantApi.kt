package com.example.middlecourseproject.data.restaurant.api

import com.example.middlecourseproject.data.restaurant.model.AdBannersResponse
import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import retrofit2.http.GET

interface RestaurantApi {
    @GET("9a30c502-f0a1-4677-8750-fa2bd40a1562")
    suspend fun getRestaurants(): List<RestaurantDto>

    @GET("7e60c5e9-8e98-428d-a418-54d0e424b9fe")
    suspend fun getAdBanners(): AdBannersResponse
}