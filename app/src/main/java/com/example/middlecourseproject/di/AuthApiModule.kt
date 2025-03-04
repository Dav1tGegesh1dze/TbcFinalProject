package com.example.middlecourseproject.di

import com.example.middlecourseproject.BuildConfig
import com.example.middlecourseproject.data.remote.services.AuthService
import com.example.middlecourseproject.data.remote.services.ProfileService
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
object AuthApiModule {

    @Provides
    @Singleton
    @AuthRetrofit
    fun provideAuthRetrofit(client: OkHttpClient): Retrofit {
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
    fun provideAuthService(@AuthRetrofit retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileService(@AuthRetrofit retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }
}