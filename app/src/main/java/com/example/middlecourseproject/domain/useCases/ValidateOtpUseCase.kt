package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.repository.TokenRepository
import javax.inject.Inject

class ValidateOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(otp: String, email: String, password: String ): Resource<Unit> {

        val otpResult = authRepository.otpValidation(email, otp)
        return if (otpResult is Resource.Success && otpResult.data.result) {
            val loginResult = authRepository.login(email, password)
            if (loginResult is Resource.Success) {
                loginResult.data.result?.accessToken?.let { token ->
                    tokenRepository.saveUserAuth(token)
                }
                Resource.Success(Unit)
            } else {
                loginResult as Resource.Error
            }
        } else {
            Resource.Error((otpResult as? Resource.Error)?.message ?: "OTP is not valid.")
        }
    }
}