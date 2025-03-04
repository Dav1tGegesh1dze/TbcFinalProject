package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

@Serializable
data class LoginDto(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: LoginResult? = null
)

@Serializable
data class LoginResult(
    val accessToken: String
)
