package com.example.middlecourseproject.di

import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.repository.AuthRepositoryImpl
import com.example.middlecourseproject.data.repository.LanguageRepositoryImpl
import com.example.middlecourseproject.data.repository.TokenRepositoryImpl
import com.example.middlecourseproject.data.repository.UserProfileRepositoryImpl
import com.example.middlecourseproject.presentation.utils.StringProviderImpl
import com.example.middlecourseproject.domain.repository.LanguageRepository
import com.example.middlecourseproject.domain.repository.TokenRepository
import com.example.middlecourseproject.domain.repository.UserProfileRepository
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
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository



    @Binds
    @Singleton
    abstract fun bindTokenRepository(
        tokenRepositoryImpl: TokenRepositoryImpl
    ): TokenRepository

    @Binds
    @Singleton
    abstract fun bindLanguageRepositoryImpl(
        languageRepositoryImpl: LanguageRepositoryImpl
    ) : LanguageRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepositoryImpl(
        userProfileRepositoryImpl: UserProfileRepositoryImpl
    ) : UserProfileRepository




    @Binds
    @Singleton
    abstract fun bindStringProvider(defaultStringProvider: StringProviderImpl): StringProvider


}
