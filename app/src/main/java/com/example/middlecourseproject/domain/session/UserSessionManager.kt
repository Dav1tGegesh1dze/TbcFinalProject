package com.example.middlecourseproject.domain.session

import com.example.middlecourseproject.domain.repository.TokenRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSessionManager @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val tokenRepository: TokenRepository
) {
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    suspend fun checkUserSession(): Boolean {
        val currentUser = firebaseAuth.currentUser
        val token = tokenRepository.getToken()
        val isUserLoggedIn = currentUser != null && !token.isNullOrEmpty()
        _isLoggedIn.value = isUserLoggedIn
        return isUserLoggedIn
    }

    suspend fun signOut() {
        firebaseAuth.signOut()
        tokenRepository.clearToken()
        _isLoggedIn.value = false
    }
}