package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.LoginDto
import com.example.middlecourseproject.domain.models.LogInDomain


fun LoginDto.toDomain ( ) : LogInDomain {
    return LogInDomain(
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}