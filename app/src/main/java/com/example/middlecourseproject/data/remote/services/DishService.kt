package com.example.middlecourseproject.data.remote.services

import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DishService {
    @GET("get")
    suspend fun getDish(
        @Query("rId") dishId: String
    ): Response<DishDto>
}