package com.example.middlecourseproject.data.remote.services

import com.example.middlecourseproject.data.remote.dtos.FoodDto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {

    @GET("search")
    suspend fun searchFoods(@Query("q") query: String): Response<FoodDto>

}
