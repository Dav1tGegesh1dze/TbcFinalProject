package com.example.middlecourseproject.domain.checkout.model

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryAddress(
    val coordinates: String,
    val details: String
)