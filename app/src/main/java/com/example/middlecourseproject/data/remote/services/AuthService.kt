package com.example.middlecourseproject.data.remote.services

import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import com.example.middlecourseproject.data.remote.dtos.OtpDto
import com.example.middlecourseproject.data.remote.dtos.LoginRequest
import com.example.middlecourseproject.data.remote.dtos.RegisterRequest
import com.example.middlecourseproject.data.remote.dtos.OtpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/UserOnboarding/register-user/manual")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterDto>

    @POST("/Auth/manual")
    suspend fun login(@Body request: LoginRequest): Response<LoginDto>

    @POST("/UserOnboarding/register-user/manual/otp-verification")
    suspend fun otpValidation(@Body request: OtpRequest): Response<OtpDto>
}
