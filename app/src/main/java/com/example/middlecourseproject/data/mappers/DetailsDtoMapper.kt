package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.DetailsDto
import com.example.middlecourseproject.domain.models.DetailsDomain


fun DetailsDto.toDomain ( ) : DetailsDomain {
    return DetailsDomain(
        errorType = this.errorType,
        errorMessage = this.errorMessage,
        result = this.result
    )
}