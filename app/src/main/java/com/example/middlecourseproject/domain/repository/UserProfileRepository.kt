package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.ProfileDto
import com.example.middlecourseproject.domain.models.ProfileDomain

interface UserProfileRepository {
    suspend fun updateDetails(request: DetailsRequest): Resource<DetailsDto>

    suspend fun getProfile() : Resource<ProfileDomain>

}
