package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.models.RegisterDomain
import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject




class ResendOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {

    suspend fun  invoke(email: String, username: String, password: String): Flow<Resource<RegisterDomain>> {
        return authRepository.register(email, username, password)
    }
}