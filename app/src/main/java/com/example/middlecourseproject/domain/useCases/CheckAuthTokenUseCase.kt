package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.TokenRepository
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class CheckAuthTokenUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(): Boolean {
        val currentUser = firebaseAuth.currentUser
        val token = tokenRepository.getToken()
        return currentUser != null && !token.isNullOrEmpty()
    }
}