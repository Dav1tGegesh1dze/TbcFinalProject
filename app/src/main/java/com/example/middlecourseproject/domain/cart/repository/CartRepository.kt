package com.example.middlecourseproject.domain.cart.repository

import com.example.middlecourseproject.domain.cart.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun addItemToCart(item: CartItem)
    suspend fun updateItemQuantity(dishId: String, quantity: Int)
    suspend fun removeItemFromCart(dishId: String)
    suspend fun clearCart()
    fun getCartTotal(): Flow<Double>
    fun getCartItemCount(): Flow<Int>
}