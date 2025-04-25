package com.example.middlecourseproject.di

import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import com.example.middlecourseproject.domain.search.SearchHelper
import com.example.middlecourseproject.domain.search.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Provides
    @Singleton
    fun provideSearchHelper(): SearchHelper {
        return SearchHelper()
    }

    @Provides
    @Singleton
    fun provideSearchUseCase(
        restaurantRepository: RestaurantRepository,
        searchHelper: SearchHelper
    ): SearchUseCase {
        return SearchUseCase(restaurantRepository, searchHelper)
    }
}