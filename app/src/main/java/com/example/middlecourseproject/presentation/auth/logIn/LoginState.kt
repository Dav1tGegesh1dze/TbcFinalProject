package com.example.middlecourseproject.presentation.auth.logIn

data class LoginState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val currentLanguage: String = "en"
)