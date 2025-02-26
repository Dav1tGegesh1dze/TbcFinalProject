package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import com.example.middlecourseproject.data.remote.dtos.OtpDto
import com.example.middlecourseproject.data.local.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<LoginDto>
    suspend fun register(email: String, userName: String, password: String): Resource<RegisterDto>
    suspend fun otpValidation(email: String, otp: String): Resource<OtpDto>
//    suspend fun saveUserAuth(token: String)
}
