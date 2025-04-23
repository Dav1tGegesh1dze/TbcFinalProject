package com.example.middlecourseproject.domain.checkout.usecase

import com.example.middlecourseproject.domain.cart.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCartTotalUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<Double> {
        return cartRepository.getCartItems().map { cartItems ->
            cartItems.sumOf { it.price * it.quantity }
        }
    }
}