package com.example.middlecourseproject.presentation.auth.logIn

sealed class LoginIntent {
    data class EnterEmail(val email: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    data object ClickLogin : LoginIntent()
    data object ClickRegister : LoginIntent()
    data object ToggleLanguage : LoginIntent()
}