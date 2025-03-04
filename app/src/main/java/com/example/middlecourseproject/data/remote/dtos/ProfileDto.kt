package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.Serializable


@Serializable
data class ProfileDto(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: Result
) {
    @Serializable
    data class Result(
        val firstName: String,
        val lastName: String,
        val genderId: Int,
        val birthDate: String,
        val cityId: Int,
        val nationalityId: Int,

        val profilePhotoUrl: String? = null,
    )
}