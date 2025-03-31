package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.mappers.toProfileDomain
import com.example.middlecourseproject.domain.models.ProfileDomain
import com.example.middlecourseproject.domain.repository.UserProfileRepository
import com.example.middlecourseproject.presentation.mappers.toProfile
import com.example.middlecourseproject.presentation.models.Profile
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    suspend operator fun invoke(): Resource<ProfileDomain> {
        return userProfileRepository.getProfile()

    }

}