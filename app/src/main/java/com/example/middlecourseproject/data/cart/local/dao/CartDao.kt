package com.example.middlecourseproject.data.cart.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.middlecourseproject.data.cart.local.entity.CartItemEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    fun getAllCartItems(): Flow<List<CartItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItemEntity)

    @Query("DELETE FROM cart_items WHERE dishId = :dishId")
    suspend fun deleteCartItem(dishId: String)

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()

    @Query("UPDATE cart_items SET quantity = :quantity WHERE dishId = :dishId")
    suspend fun updateItemQuantity(dishId: String, quantity: Int)

    @Query("SELECT * FROM cart_items WHERE dishId = :dishId")
    suspend fun getCartItemById(dishId: String): CartItemEntity?
}