package com.example.middlecourseproject.domain.cart.usecase

import com.example.middlecourseproject.domain.cart.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItemCountUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<Int> {
        return cartRepository.getCartItemCount()
    }
}