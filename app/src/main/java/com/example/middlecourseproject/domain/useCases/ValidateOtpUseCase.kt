package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.repository.TokenRepository
import com.example.middlecourseproject.domain.utils.AppError
import com.example.middlecourseproject.domain.utils.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ValidateOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {

    fun invoke(otp: String, email: String, password: String): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading(true))
        val otpResult = authRepository.otpValidation(email, otp)
            .first { it is Resource.Success || it is Resource.Error }
        if (otpResult is Resource.Success && otpResult.data.result) {
            val loginResult = authRepository.login(email, password)
                .first { it is Resource.Success || it is Resource.Error }
            if (loginResult is Resource.Success) {
                loginResult.data.result?.accessToken?.let { token ->
                    tokenRepository.saveUserAuth(token)
                }
                emit(Resource.Success(Unit))
            } else {
                emit(loginResult as Resource.Error)
            }
        } else {
            emit(otpResult as Resource.Error)
        }
        emit(Resource.Loading(false))
    }
}