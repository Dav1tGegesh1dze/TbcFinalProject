package com.example.middlecourseproject.di

import com.example.middlecourseproject.presentation.imageLoading.ImageLoader
import com.example.middlecourseproject.presentation.imageLoading.GlideImageLoader
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.presentation.utils.ErrorMapperImpl
import com.example.middlecourseproject.presentation.utils.StringProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Binds
    @Singleton
    abstract fun bindImageLoader(
        glideImageLoader: GlideImageLoader
    ): ImageLoader



}