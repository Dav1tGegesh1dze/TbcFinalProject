package com.example.middlecourseproject.domain.mappers

import com.example.middlecourseproject.data.remote.dtos.ProfileDto
import com.example.middlecourseproject.domain.models.Profile

fun ProfileDto.toProfile(): Profile {
    return Profile(
        firstName = this.result.firstName,
        lastName = this.result.lastName,
        profilePhotoUrl = this.result.profilePhotoUrl,
        genderId = this.result.genderId,
        nationalityId = this.result.nationalityId,
        birthDate = this.result.birthDate,
        cityId = this.result.cityId
    )
}