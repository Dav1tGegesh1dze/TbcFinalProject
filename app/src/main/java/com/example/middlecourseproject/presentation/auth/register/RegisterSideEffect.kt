package com.example.middlecourseproject.presentation.auth.register

sealed class RegisterSideEffect {
    data class ShowSnackbar(val message: String) : RegisterSideEffect()
    data class NavigateToOtpValidation(val email: String,  val password: String) : RegisterSideEffect()
    data object NavigateToLogin : RegisterSideEffect()
}