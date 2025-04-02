package com.example.middlecourseproject.presentation.auth.otpValidation

sealed class OtpValidationSideEffect {
    data class ShowValidationError(val message: String) : OtpValidationSideEffect()
    data object ShowResendSuccess : OtpValidationSideEffect()
    data class ShowResendError(val message: String) : OtpValidationSideEffect()
    data object NavigateToDetails : OtpValidationSideEffect()
}