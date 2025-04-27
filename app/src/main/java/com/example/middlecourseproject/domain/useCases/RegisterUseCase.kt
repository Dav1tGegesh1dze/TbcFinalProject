package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.RegisterDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String,  password: String): Flow<Resource<RegisterDomain>> {
        return authRepository.register(email,  password)
    }
}