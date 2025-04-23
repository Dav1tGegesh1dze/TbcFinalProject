package com.example.middlecourseproject.domain.checkout.usecase

import com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import javax.inject.Inject

class PlaceOrderUseCase @Inject constructor(
    private val checkoutRepository: CheckoutRepository,
    private val clearCartUseCase: ClearCartUseCase
) {
    suspend operator fun invoke() {
        // Place the order
        val orderId = checkoutRepository.placeOrder()

        // Clear the cart after successful order
        clearCartUseCase()
    }
}