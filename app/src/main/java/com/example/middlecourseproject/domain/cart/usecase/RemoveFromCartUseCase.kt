package com.example.middlecourseproject.domain.cart.usecase

import com.example.middlecourseproject.domain.cart.repository.CartRepository
import javax.inject.Inject

class RemoveFromCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(dishId: String) {
        cartRepository.removeItemFromCart(dishId)
    }
}