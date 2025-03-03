package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.domain.mappers.toDish
import com.example.middlecourseproject.domain.mappers.toProfile
import com.example.middlecourseproject.domain.models.Dish
import com.example.middlecourseproject.domain.models.Profile
import com.example.middlecourseproject.domain.repository.UserProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    suspend operator fun invoke(): Resource<Profile> {
        return when (val result = userProfileRepository.getProfile()) {
            is Resource.Success -> {
                Resource.Success(result.data.toProfile())
            }
            is Resource.Error -> Resource.Error(result.message)
            is Resource.Loading -> Resource.Loading
            is Resource.Idle -> Resource.Idle
        }
    }

}