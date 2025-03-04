package com.example.middlecourseproject.domain.useCases


import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.domain.repository.TokenRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(email: String, password: String): Resource<LoginDto> {
        val result = authRepository.login(email, password)
        if (result is Resource.Success) {
            result.data.result?.accessToken?.let { token ->
                tokenRepository.saveUserAuth(token)
            }
        }
        return result
    }
}