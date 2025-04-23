package com.example.middlecourseproject.domain.cart

import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    val dishId: String,
    val restaurantId: String,
    val name: String,
    val nameKa: String,
    val price: Double,
    val image: String,
    val quantity: Int = 1
) {
    val subtotal: Double
        get() = price * quantity
}