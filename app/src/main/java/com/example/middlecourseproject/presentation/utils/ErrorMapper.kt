package com.example.middlecourseproject.presentation.utils

import com.example.middlecourseproject.domain.utils.AppError

interface ErrorMapper {
    fun mapToMessage(appError: AppError): String
}