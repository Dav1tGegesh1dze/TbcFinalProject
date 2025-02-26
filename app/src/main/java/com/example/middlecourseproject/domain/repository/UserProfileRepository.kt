package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.local.Resource

interface UserProfileRepository {
    suspend fun updateDetails(request: DetailsRequest): Resource<DetailsDto>

}
