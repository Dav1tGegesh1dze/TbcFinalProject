package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.domain.models.LogInDomain
import com.example.middlecourseproject.domain.models.RegisterDomain
import com.example.middlecourseproject.presentation.models.LogIn
import com.example.middlecourseproject.presentation.models.Register

fun RegisterDomain.toPresentation ( ) : Register {
    return Register (
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}