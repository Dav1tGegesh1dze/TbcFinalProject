package com.example.middlecourseproject.domain.checkout.repository

import com.example.middlecourseproject.domain.checkout.model.DeliveryAddress
import com.example.middlecourseproject.domain.checkout.model.PaymentMethod

interface CheckoutRepository {
    suspend fun getDeliveryAddress(): DeliveryAddress
    suspend fun updateDeliveryAddress(deliveryAddress: DeliveryAddress)
    suspend fun getDefaultPaymentMethod(): PaymentMethod?
    suspend fun addPaymentMethod(paymentMethod: PaymentMethod, setAsDefault: Boolean = true)
    suspend fun placeOrder(): String
}