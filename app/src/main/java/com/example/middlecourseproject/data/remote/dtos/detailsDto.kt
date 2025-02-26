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
    // Use a simple ISO date string ("yyyy-MM-dd") for birthDate
    val birthDate: String,
    val cityId: Int,
    val nationalityId: Int,
    val bio: String = "",           // Always null in your app
    val height: Int = 0,           // Always null
    val weight: Int = 0,           // Always null
    val freeTimeStart: Time? = null,   // Always null
    val freeTimeEnd: Time? = null,     // Always null
    val profilePhoto: String?           // URL string (or null if not provided)
)

@Serializable
data class DetailsDto(
    val errorType: String? = null,
    val errorMessage: String? = null,
    val result: Boolean
)
