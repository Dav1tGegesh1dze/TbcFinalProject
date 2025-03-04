package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import javax.inject.Inject




class ResendOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke(email: String, username: String, password: String): Resource<Boolean> {

        val result = authRepository.register(email, username, password)
        return if (result is Resource.Success) {
            Resource.Success(true)
        } else {
            result as Resource.Error
        }
    }
}