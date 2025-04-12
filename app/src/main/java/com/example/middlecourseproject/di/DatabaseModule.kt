package com.example.middlecourseproject.di

import android.content.Context
import androidx.room.Room
import com.example.middlecourseproject.data.cart.local.dao.CartDao

import com.example.middlecourseproject.data.local.roomDB.dao.FoodDao

import com.example.middlecourseproject.data.local.roomDB.database.AppDatabase


import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.presentation.utils.ErrorMapperImpl
import com.example.middlecourseproject.presentation.utils.StringProvider
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

    @Provides
    fun provideCartDao(appDatabase: AppDatabase): CartDao = appDatabase.cartDao()

    @Provides
    @Singleton
    fun provideErrorMapper(stringProvider: StringProvider): ErrorMapper {
        return ErrorMapperImpl(stringProvider)
    }
}