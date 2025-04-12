package com.example.middlecourseproject.domain.cart.usecase


import com.example.middlecourseproject.domain.cart.CartItem
import com.example.middlecourseproject.domain.cart.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> {
        return cartRepository.getCartItems()
    }
}

