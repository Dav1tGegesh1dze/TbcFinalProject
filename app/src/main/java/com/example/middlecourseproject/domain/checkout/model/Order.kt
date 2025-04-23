package com.example.middlecourseproject.domain.checkout.model

import com.example.middlecourseproject.domain.cart.CartItem
import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: String,
    val items: List<CartItem>,
    val subtotal: Double,
    val bagFee: Double,
    val smallOrderFee: Double,
    val serviceFee: Double,
    val deliveryFee: Double,
    val tip: Double,
    val total: Double,
    val paymentMethodId: String,
    val deliveryAddress: DeliveryAddress,
    val orderDate: Long,
    val estimatedDeliveryTime: Long
)
