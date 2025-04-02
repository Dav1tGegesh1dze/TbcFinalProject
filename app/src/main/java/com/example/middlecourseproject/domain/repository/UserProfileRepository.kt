package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.domain.models.DetailsDomain
import com.example.middlecourseproject.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    suspend fun updateDetails(request: DetailsRequest): Flow<Resource<DetailsDomain>>

}
