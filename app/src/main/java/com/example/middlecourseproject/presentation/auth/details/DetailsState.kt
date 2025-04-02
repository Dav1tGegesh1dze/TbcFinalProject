package com.example.middlecourseproject.presentation.auth.details

data class DetailsState(
    val firstName: String = "",
    val lastName: String = "",
    val birthDate: String = "",
    val genderId: Int? = null,
    val cityId: Int? = null,
    val nationalityId: Int? = null,
    val profilePhotoBase64: String? = null,
    val isLoading: Boolean = false,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val birthDateError: String? = null,
    val genderError: String? = null,
    val cityError: String? = null,
    val nationalityError: String? = null
)