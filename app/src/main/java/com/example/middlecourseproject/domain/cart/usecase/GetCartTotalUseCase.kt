package com.example.middlecourseproject.domain.cart.usecase

import com.example.middlecourseproject.domain.cart.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartTotalUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<Double> {
        return cartRepository.getCartTotal()
    }
}