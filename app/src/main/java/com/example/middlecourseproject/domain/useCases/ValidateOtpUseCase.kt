package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.domain.repository.TokenRepository
import javax.inject.Inject

class ValidateOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {
    /**
     * Validates the OTP. If successful, it retrieves stored credentials, calls the login
     * endpoint (which generates the JWT), saves the token, and returns success.
     */
    suspend operator fun invoke(otp: String, email: String, password: String ): Resource<Unit> {
        // Retrieve credentials from the dedicated repository.
//        val email = credentialsRepository.getEmail() ?: return Resource.Error("Email missing")
//        val password = credentialsRepository.getPassword() ?: return Resource.Error("Password missing")

        // Validate the OTP.
        val otpResult = authRepository.otpValidation(email, otp)
        return if (otpResult is Resource.Success && otpResult.data.result) {
            // OTP is valid. Proceed with login to get JWT.
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