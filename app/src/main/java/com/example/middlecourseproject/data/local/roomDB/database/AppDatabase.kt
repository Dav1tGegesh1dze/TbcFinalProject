package com.example.middlecourseproject.data.local.roomDB.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity
import com.example.middlecourseproject.data.local.roomDB.dao.FoodDao


@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}