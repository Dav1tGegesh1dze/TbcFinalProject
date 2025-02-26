package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.Serializable


@Serializable
data class RegisterRequest(
    val email: String,
    val password: String,
    val userName:String
    )

@Serializable
data class RegisterDto(
    val errorType : String?,
    val errorMessage : String?,
    val result : Boolean
)