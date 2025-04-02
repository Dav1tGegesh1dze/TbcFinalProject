package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.domain.models.LogInDomain
import com.example.middlecourseproject.domain.models.OtpDomain
import com.example.middlecourseproject.domain.models.RegisterDomain
import com.example.middlecourseproject.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Flow<Resource<LogInDomain>>
    suspend fun register(email: String, userName: String, password: String): Flow<Resource<RegisterDomain>>
    suspend fun otpValidation(email: String, otp: String): Flow<Resource<OtpDomain>>
}
