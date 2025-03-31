package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.ProfileDto
import com.example.middlecourseproject.domain.models.ProfileDomain

fun ProfileDto.toProfileDomain(): ProfileDomain {
    return ProfileDomain(
        firstName = this.result.firstName,
        lastName = this.result.lastName,
        profilePhotoUrl = this.result.profilePhotoUrl,
        genderId = this.result.genderId,
        nationalityId = this.result.nationalityId,
        birthDate = this.result.birthDate,
        cityId = this.result.cityId
    )
}