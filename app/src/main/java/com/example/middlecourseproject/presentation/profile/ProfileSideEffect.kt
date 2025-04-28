package com.example.middlecourseproject.presentation.profile

sealed class ProfileSideEffect {
    data class ShowSnackbar(val message: String) : ProfileSideEffect()
    data object NavigateToLogin : ProfileSideEffect()
    data class LanguageToggled(val language: String) : ProfileSideEffect()
}