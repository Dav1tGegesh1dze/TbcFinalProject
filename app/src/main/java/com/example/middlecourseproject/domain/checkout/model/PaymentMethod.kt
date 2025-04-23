package com.example.middlecourseproject.domain.checkout.model

import kotlinx.serialization.Serializable

@Serializable
data class PaymentMethod(
    val id: String,
    val cardType: CardType,
    val lastFour: String,
    val expiryMonth: Int,
    val expiryYear: Int,
    val cardholderName: String
)
@Serializable
enum class CardType {
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS,
    UNKNOWN
}
