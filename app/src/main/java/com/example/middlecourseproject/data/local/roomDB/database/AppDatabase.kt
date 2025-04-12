package com.example.middlecourseproject.data.local.roomDB.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.middlecourseproject.data.cart.local.dao.CartDao
import com.example.middlecourseproject.data.cart.local.entity.CartItemEntity
import com.example.middlecourseproject.data.local.roomDB.dao.FoodDao
import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity


@Database(
    entities = [
        RecipeEntity::class,
        CartItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun cartDao(): CartDao
}