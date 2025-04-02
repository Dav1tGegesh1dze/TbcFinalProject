package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.OtpDto
import com.example.middlecourseproject.domain.models.OtpDomain

fun OtpDto.toDomain ( ) : OtpDomain {
    return OtpDomain(
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}