package com.example.middlecourseproject.di

import com.example.middlecourseproject.domain.imageLoading.ImageLoader
import com.example.middlecourseproject.presentation.imageLoading.GlideImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageModule {

    @Binds
    @Singleton
    abstract fun bindImageLoader(
        glideImageLoader: GlideImageLoader
    ): ImageLoader


}