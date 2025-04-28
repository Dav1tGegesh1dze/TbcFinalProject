package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.session.UserSessionManager
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val userSessionManager: UserSessionManager
) {
    suspend operator fun invoke() {
        userSessionManager.signOut()
    }
}