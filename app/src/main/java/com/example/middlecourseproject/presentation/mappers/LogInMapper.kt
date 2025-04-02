package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.domain.models.LogInDomain
import com.example.middlecourseproject.presentation.models.LogIn


fun LogInDomain.toPresentation ( ) : LogIn {
    return LogIn (
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}