package com.example.middlecourseproject.di

import com.example.middlecourseproject.BuildConfig
import com.example.middlecourseproject.data.remote.services.DishService
import com.example.middlecourseproject.data.remote.services.FoodService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoodApiModule {

    @Provides
    @Singleton
    @FoodRetrofit
    fun provideFoodRetrofit(client: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_FOOD_URL)
            .client(client)
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodService(@FoodRetrofit retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishService(@FoodRetrofit retrofit: Retrofit): DishService {
        return retrofit.create(DishService::class.java)
    }
}