package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, userName: String, password: String): Resource<RegisterDto> {
        val result = authRepository.register(email, userName, password)
//        if (result is Resource.Success) {
//            authRepository.saveRegisterCredentials(email, userName, password)
//        }
        return result
    }
}