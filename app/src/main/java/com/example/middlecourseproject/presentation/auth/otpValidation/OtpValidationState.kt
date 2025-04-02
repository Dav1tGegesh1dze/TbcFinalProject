package com.example.middlecourseproject.presentation.auth.otpValidation

data class OtpValidationState(
    val timerSeconds: Int = 180,
    val isValidating: Boolean = false,
    val isResending: Boolean = false
)