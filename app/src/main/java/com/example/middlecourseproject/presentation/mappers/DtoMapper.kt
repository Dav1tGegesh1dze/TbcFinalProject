package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.domain.models.OtpDomain
import com.example.middlecourseproject.presentation.models.Otp

fun OtpDomain.toPresentation ( ) : Otp {
    return Otp (
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}