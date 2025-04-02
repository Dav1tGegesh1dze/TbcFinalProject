package com.example.middlecourseproject.presentation.auth.otpValidation

sealed class OtpValidationIntent {
    data class SubmitOtp(val otp: String) : OtpValidationIntent()
    data object ResendOtp : OtpValidationIntent()
}