package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.RegisterDto
import com.example.middlecourseproject.domain.models.RegisterDomain

fun RegisterDto.toDomain ( ) : RegisterDomain {
    return RegisterDomain(
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}