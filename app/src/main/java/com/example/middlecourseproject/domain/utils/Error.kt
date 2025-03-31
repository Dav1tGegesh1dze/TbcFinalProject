package com.example.middlecourseproject.domain.utils

enum class ErrorType {
    NOT_CORRECT_EMAIL_OR_PASSWORD,
    ALREADY_USED_EMAILADDRESS,
    OTP_ERROR_VALID,
    OTP_ERROR_CORRECT,
    EXPIRED_JWT,
    OTHER
}

sealed class AppError {
    data class ApiError(val errorType: ErrorType, val message: String? = null) : AppError()
    data class NetworkError(val message: String) : AppError()
    data object TimeoutError : AppError()
}