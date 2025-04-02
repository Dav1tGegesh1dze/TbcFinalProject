package com.example.middlecourseproject.domain.useCases


import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.domain.models.LogInDomain
import com.example.middlecourseproject.domain.repository.TokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<Resource<LogInDomain>> {
        return authRepository.login(email, password).onEach { resource ->
            if (resource is Resource.Success) {
                resource.data.result?.accessToken?.let { token ->
                    tokenRepository.saveUserAuth(token)
                }
            }
        }
    }
}