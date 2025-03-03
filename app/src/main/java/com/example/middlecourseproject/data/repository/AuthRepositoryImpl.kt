package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.data.remote.services.AuthService
import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import com.example.middlecourseproject.data.remote.dtos.OtpDto
import com.example.middlecourseproject.data.remote.dtos.LoginRequest
import com.example.middlecourseproject.data.remote.dtos.RegisterRequest
import com.example.middlecourseproject.data.remote.dtos.OtpRequest
import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.utils.ApiHelper
import com.example.middlecourseproject.data.local.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val apiHelper: ApiHelper,
) : AuthRepository {

    override suspend fun login(email: String, password: String): Resource<LoginDto> {
        return apiHelper.handleHttpRequest {
            authService.login(LoginRequest(email, password))
        }
    }

    override suspend fun register(email: String, userName: String, password: String): Resource<RegisterDto> {
        return apiHelper.handleHttpRequest {
            authService.register(RegisterRequest(email, password, userName))
        }
    }

    override suspend fun otpValidation(email: String, otp: String): Resource<OtpDto> {
        return apiHelper.handleHttpRequest {
            authService.otpValidation(OtpRequest(email, otp))
        }
    }




}
