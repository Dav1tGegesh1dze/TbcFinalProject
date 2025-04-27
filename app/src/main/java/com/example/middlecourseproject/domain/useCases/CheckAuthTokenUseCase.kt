package com.example.middlecourseproject.domain.useCases

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class CheckAuthTokenUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend operator fun invoke(): Boolean {
        return firebaseAuth.currentUser != null
    }
}