package com.example.middlecourseproject.presentation.auth.register

sealed class RegisterIntent {
    data class EnterEmail(val email: String) : RegisterIntent()
    data class EnterPassword(val password: String) : RegisterIntent()
    data object ClickRegister : RegisterIntent()
    data object ClickLogin : RegisterIntent()
}