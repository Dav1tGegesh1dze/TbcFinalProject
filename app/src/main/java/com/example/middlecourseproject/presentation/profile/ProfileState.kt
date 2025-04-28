package com.example.middlecourseproject.presentation.profile

data class ProfileState(
    val isLoading: Boolean = false,
    val isDarkMode: Boolean = false,
    val currentLanguage: String = "en"
)