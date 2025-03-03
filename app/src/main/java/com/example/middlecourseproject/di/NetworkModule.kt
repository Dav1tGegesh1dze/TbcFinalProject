package com.example.middlecourseproject.di

import android.content.Context
import androidx.room.Room
import com.example.middlecourseproject.BuildConfig
import com.example.middlecourseproject.data.local.roomDB.database.AppDatabase
import com.example.middlecourseproject.data.local.roomDB.dao.FoodDao
import com.example.middlecourseproject.data.remote.services.AuthService
import com.example.middlecourseproject.data.remote.services.DishService
import com.example.middlecourseproject.data.remote.services.FoodService
import com.example.middlecourseproject.data.remote.services.ProfileService

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(logging)
        }.build()
    }

    @Provides
    @Singleton
    @Named("authRetrofit")
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
            }.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    @Named("foodRetrofit")
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
    fun provideAuthService(@Named("authRetrofit") retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileService(@Named("authRetrofit") retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

    @Provides
    @Singleton
    fun provideFoodService(@Named("foodRetrofit") retrofit: Retrofit) : FoodService{
        return retrofit.create(FoodService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishService(@Named("foodRetrofit") retrofit: Retrofit) : DishService{
        return retrofit.create(DishService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideFoodDao(appDatabase: AppDatabase): FoodDao = appDatabase.foodDao()
}
