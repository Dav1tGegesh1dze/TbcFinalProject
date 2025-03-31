package com.example.middlecourseproject.presentation.utils

import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.utils.AppError
import com.example.middlecourseproject.domain.utils.ErrorType
import javax.inject.Inject

interface StringProvider {
    fun getString(resId: Int): String
}

class ErrorMapperImpl @Inject constructor(
    private val stringProvider: StringProvider
) : ErrorMapper {

    override fun mapToMessage(appError: AppError): String {
        return when (appError) {
            is AppError.ApiError -> {
                appError.message ?: when (appError.errorType) {
                    ErrorType.NOT_CORRECT_EMAIL_OR_PASSWORD -> stringProvider.getString(R.string.incorect_email_or_password)
                    ErrorType.ALREADY_USED_EMAILADDRESS -> stringProvider.getString(R.string.already_registered_email)
                    ErrorType.OTP_ERROR_VALID -> stringProvider.getString(R.string.invalid_otp)
                    ErrorType.OTP_ERROR_CORRECT -> stringProvider.getString(R.string.invalid_otp1)
                    ErrorType.EXPIRED_JWT -> stringProvider.getString(R.string.expired_jwt)
                    ErrorType.OTHER -> stringProvider.getString(R.string.other_error)
                }
            }
            is AppError.NetworkError -> stringProvider.getString(R.string.internet_error)
            AppError.TimeoutError -> stringProvider.getString(R.string.request_timed_out)
        }
    }
}