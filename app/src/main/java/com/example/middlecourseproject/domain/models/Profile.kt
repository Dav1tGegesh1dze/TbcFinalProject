package com.example.middlecourseproject.domain.models

data class Profile (
    val firstName: String,
    val lastName: String,
    val genderId: Int,
    val birthDate: String,
    val cityId: Int,
    val nationalityId: Int,
    val profilePhotoUrl: String?
)