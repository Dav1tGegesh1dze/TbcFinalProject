package com.example.middlecourseproject.data.restaurant.model.mappers

import com.example.middlecourseproject.data.restaurant.model.AdBannerDto
import com.example.middlecourseproject.domain.restaurant.model.AdBanner

fun AdBannerDto.toDomain(): AdBanner {
    return AdBanner(
        id = this.id,
        title = this.title,
        description = this.description,
        mediaType = this.mediaType,
        mediaUrl = this.mediaUrl,
        thumbnailUrl = this.thumbnailUrl,
        actionType = this.actionType,
        actionTarget = this.actionTarget,
        backgroundColor = this.backgroundColor
    )
}