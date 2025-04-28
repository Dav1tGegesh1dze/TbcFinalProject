package com.example.middlecourseproject.presentation.profile

sealed class ProfileIntent {
    data object SignOut : ProfileIntent()
    data object ToggleTheme : ProfileIntent()
    data object ToggleLanguage : ProfileIntent()
}