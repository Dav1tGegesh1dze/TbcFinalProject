package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: Boolean? = null
)