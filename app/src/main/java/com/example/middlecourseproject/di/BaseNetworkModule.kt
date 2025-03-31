package com.example.middlecourseproject.di

import com.example.middlecourseproject.BuildConfig
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.presentation.utils.ErrorMapperImpl
import com.example.middlecourseproject.presentation.utils.StringProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseNetworkModule {

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

}