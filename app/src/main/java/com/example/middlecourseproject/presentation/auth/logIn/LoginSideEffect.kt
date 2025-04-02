package com.example.middlecourseproject.presentation.auth.logIn

sealed class LoginSideEffect {
    data class ShowSnackbar(val message: String) : LoginSideEffect()
    data object NavigateToHome : LoginSideEffect()
    data object NavigateToRegister : LoginSideEffect()
    data class LanguageToggled(val language: String) : LoginSideEffect()
}