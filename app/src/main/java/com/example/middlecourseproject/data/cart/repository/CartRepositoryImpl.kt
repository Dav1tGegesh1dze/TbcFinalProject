package com.example.middlecourseproject.data.cart.repository

import com.example.middlecourseproject.data.cart.local.dao.CartDao
import com.example.middlecourseproject.data.cart.local.entity.CartItemEntity
import com.example.middlecourseproject.domain.cart.CartItem
import com.example.middlecourseproject.domain.cart.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDao.getAllCartItems().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    override suspend fun addItemToCart(item: CartItem) {

        val existingItem = cartDao.getCartItemById(item.dishId)
        if (existingItem != null) {
            // Update
            cartDao.updateItemQuantity(
                dishId = existingItem.dishId,
                quantity = existingItem.quantity + item.quantity
            )
        } else {

            cartDao.insertCartItem(item.toEntity())
        }
    }

    override suspend fun updateItemQuantity(dishId: String, quantity: Int) {
        if (quantity <= 0) {
            cartDao.deleteCartItem(dishId)
        } else {
            cartDao.updateItemQuantity(dishId, quantity)
        }
    }

    override suspend fun removeItemFromCart(dishId: String) {
        cartDao.deleteCartItem(dishId)
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }

    override fun getCartTotal(): Flow<Double> {
        return getCartItems().map { items ->
            items.sumOf { it.subtotal }
        }
    }

    override fun getCartItemCount(): Flow<Int> {
        return getCartItems().map { it.size }
    }

    private fun CartItemEntity.toDomainModel(): CartItem {
        return CartItem(
            dishId = dishId,
            restaurantId = restaurantId,
            name = name,
            nameKa = nameKa,
            price = price,
            image = image,
            quantity = quantity
        )
    }

    private fun CartItem.toEntity(): CartItemEntity {
        return CartItemEntity(
            dishId = dishId,
            restaurantId = restaurantId,
            name = name,
            nameKa = nameKa,
            price = price,
            image = image,
            quantity = quantity
        )
    }
}