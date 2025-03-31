package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.domain.models.ProfileDomain
import com.example.middlecourseproject.presentation.models.Profile

fun ProfileDomain.toProfile(): Profile {
    return Profile(
        firstName = this.firstName,
        lastName = this.lastName,
        profilePhotoUrl = this.profilePhotoUrl,
        genderId = this.genderId,
        nationalityId = this.nationalityId,
        birthDate = this.birthDate,
        cityId = this.cityId
    )
}