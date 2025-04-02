package com.example.middlecourseproject.presentation.auth.register

data class RegisterState(
    val isLoading: Boolean = false,
    val email: String = "",
    val userName: String = "",
    val password: String = "",
    val emailError: String? = null,
    val userNameError: String? = null,
    val passwordError: String? = null
)