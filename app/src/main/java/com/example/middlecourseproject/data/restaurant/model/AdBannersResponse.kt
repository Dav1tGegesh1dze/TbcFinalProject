package com.example.middlecourseproject.data.restaurant.model

import kotlinx.serialization.Serializable

@Serializable
data class AdBannersResponse(
    val adBanners: List<AdBannerDto>
)

@Serializable
data class AdBannerDto(
    val id: String,
    val title: String,
    val description: String,
    val mediaType: String,
    val mediaUrl: String,
    val thumbnailUrl: String? = null,
    val actionType: String,
    val actionTarget: String,
    val backgroundColor: String? = null
)