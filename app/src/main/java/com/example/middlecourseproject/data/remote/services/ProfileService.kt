package com.example.middlecourseproject.data.remote.services

import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ProfileService {

    @POST("/UserProfile/create-or-update")
    suspend fun updateDetails(
        @Header("Authorization") token: String,
        @Body request: DetailsRequest
    ): Response<DetailsDto>
}
