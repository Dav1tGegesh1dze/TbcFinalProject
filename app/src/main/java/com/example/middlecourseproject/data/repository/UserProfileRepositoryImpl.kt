package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.data.local.DataStoreManager
import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.remote.services.ProfileService
import com.example.middlecourseproject.domain.repository.UserProfileRepository
import com.example.middlecourseproject.data.utils.ApiHelper
import com.example.middlecourseproject.data.local.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProfileRepositoryImpl @Inject constructor(
    private val profileService: ProfileService,
    private val apiHelper: ApiHelper,
    private val dataStoreManager: DataStoreManager

) : UserProfileRepository {

    override suspend fun updateDetails( request: DetailsRequest): Resource<DetailsDto> {
        val token = dataStoreManager.getToken().first() ?: ""
        println(request)
        println(token)
        return apiHelper.handleHttpRequest {
            profileService.updateDetails("Bearer $token", request)
        }
    }

}
