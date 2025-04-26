package com.example.middlecourseproject.domain.restaurant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdBanner(
    val id: String,
    val title: String,
    val description: String,
    val mediaType: String,
    val mediaUrl: String,
    val thumbnailUrl: String? = null,
    val actionType: String,
    val actionTarget: String,
    val backgroundColor: String? = null
): Parcelable