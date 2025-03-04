package com.example.middlecourseproject.di

import android.content.Context
import androidx.room.Room
import com.example.middlecourseproject.data.local.roomDB.database.AppDatabase
import com.example.middlecourseproject.data.local.roomDB.dao.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideFoodDao(appDatabase: AppDatabase): FoodDao = appDatabase.foodDao()
}