package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.data.local.datastore.DataStoreManager
import com.example.middlecourseproject.data.mappers.toProfileDomain
import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.remote.services.ProfileService
import com.example.middlecourseproject.domain.repository.UserProfileRepository
import com.example.middlecourseproject.data.utils.ApiHelper
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.ProfileDto
import com.example.middlecourseproject.domain.models.ProfileDomain
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

    override suspend fun getProfile(): Resource<ProfileDomain> {
        return when( val result =  apiHelper.handleHttpRequest {
            val token = dataStoreManager.getToken().first() ?: ""

            profileService.getProfile("Bearer $token")
        } ) {
            is Resource.Success -> {
                Resource.Success(result.data.toProfileDomain())
            }
            is Resource.Error -> {
                Resource.Error(result.message)
            }
            is Resource.Loading ->{
                Resource.Loading
            }
            is Resource.Idle ->{
                Resource.Idle
            }
        }



    }

}
