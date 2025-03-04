package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Time(
    val hour: Int,
    val minute: Int
)

@Serializable
data class DetailsRequest(
    val firstName: String,
    val lastName: String,
    val genderId: Int,
    val homeStadiumId: Int,
    val birthDate: String,
    val cityId: Int,
    val nationalityId: Int,
    val bio: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val freeTimeStart: Time? = null,
    val freeTimeEnd: Time? = null,
    val profilePhoto: String?
)

@Serializable
data class DetailsDto(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: Boolean
)
