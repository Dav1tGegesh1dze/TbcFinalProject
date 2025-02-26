package com.example.middlecourseproject.data.remote.dtos
import kotlinx.serialization.Serializable



@Serializable
data class OtpDto (
    val errorType : String?,
    val errorMessage : String?,
    val result : Boolean
)


@Serializable
data class OtpRequest (
    val email: String,
    val otp : String
)