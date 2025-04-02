package com.example.middlecourseproject.domain.models

import com.example.middlecourseproject.data.remote.dtos.LoginResult


data class LogInDomain(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: LoginResult? = null
)