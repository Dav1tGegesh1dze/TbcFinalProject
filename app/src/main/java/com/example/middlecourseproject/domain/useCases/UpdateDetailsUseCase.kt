package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.UserProfileRepository
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.domain.models.DetailsDomain
import com.example.middlecourseproject.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateDetailsUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    suspend operator fun invoke(request: DetailsRequest): Flow<Resource<DetailsDomain>> {

        val result = userProfileRepository.updateDetails(request)

        return result
    }
}