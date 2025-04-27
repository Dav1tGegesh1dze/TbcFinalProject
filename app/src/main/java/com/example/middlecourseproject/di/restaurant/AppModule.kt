package com.example.middlecourseproject.di.restaurant

import android.content.Context
import com.example.middlecourseproject.data.restaurant.api.RestaurantApi
import com.example.middlecourseproject.data.restaurant.api.RetrofitClient
import com.example.middlecourseproject.data.restaurant.repository.RestaurantRepositoryImpl
import com.example.middlecourseproject.domain.checkout.manager.OrderManager
import com.example.middlecourseproject.domain.checkout.notification.NotificationService

import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // BASE MOCKY, We might change later for updates
    private const val BASE_URL = "https://run.mocky.io/v3/"

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofitClient: RetrofitClient): RestaurantApi {
        return retrofitClient.createRestaurantApi(BASE_URL)
    }

    @Provides
    @Singleton
    fun provideRestaurantRepository(api: RestaurantApi): RestaurantRepository {
        return RestaurantRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNotificationService(@ApplicationContext context: Context): NotificationService {
        return NotificationService(context)
    }

    @Provides
    @Singleton
    fun provideOrderManager(
        @ApplicationContext context: Context,
        notificationService: NotificationService
    ): OrderManager {
        return OrderManager(context, notificationService)
    }
}