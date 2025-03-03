package com.example.middlecourseproject.data.remote.services

import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import com.example.middlecourseproject.data.remote.dtos.OtpDto
import com.example.middlecourseproject.data.remote.dtos.LoginRequest
import com.example.middlecourseproject.data.remote.dtos.RegisterRequest
import com.example.middlecourseproject.data.remote.dtos.OtpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FoodService {

    @GET("search")
    suspend fun searchFoods(@Query("q") query: String): Response<FoodDto>

}
