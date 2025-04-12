package com.example.middlecourseproject.data.cart.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItemEntity(
    @PrimaryKey
    val dishId: String,
    val restaurantId: String,
    val name: String,
    val nameKa: String,
    val price: Double,
    val image: String,
    val quantity: Int = 1
)