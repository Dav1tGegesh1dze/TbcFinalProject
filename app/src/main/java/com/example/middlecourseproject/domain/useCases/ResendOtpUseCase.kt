package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import javax.inject.Inject

/**
 * This use case re-sends the OTP by calling the registration API.
 * It expects the email, username, and password.
 */


class ResendOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    /**
     * Resends the OTP by calling the registration endpoint (assuming that triggers a new OTP).
     * Uses stored credentials.
     */
    suspend operator fun invoke(email: String, username: String, password: String): Resource<Boolean> {
//        val email = credentialsRepository.getEmail() ?: return Resource.Error("Missing email")
//        val username = credentialsRepository.getUsername() ?: return Resource.Error("Missing username")
//        val password = credentialsRepository.getPassword() ?: return Resource.Error("Missing password")

        val result = authRepository.register(email, username, password)
        return if (result is Resource.Success) {
            Resource.Success(true)
        } else {
            result as Resource.Error
        }
    }
}