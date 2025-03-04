package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.UserProfileRepository
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.domain.utils.Resource
import javax.inject.Inject

class UpdateDetailsUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    suspend operator fun invoke(request: DetailsRequest): Resource<DetailsDto> {

        val result = userProfileRepository.updateDetails(request)

        return result
    }
}