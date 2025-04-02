package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.domain.models.DetailsDomain
import com.example.middlecourseproject.presentation.models.Details

fun DetailsDomain.toPresentation ( ) : Details {
    return Details (
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}