package com.example.middlecourseproject.presentation.models

import com.example.middlecourseproject.data.remote.dtos.LoginResult

data class LogIn (
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: LoginResult? = null
)