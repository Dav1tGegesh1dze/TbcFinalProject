package com.example.middlecourseproject.di

import com.example.middlecourseproject.data.local.sharedPreferences.LocaleHelper
import com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LocaleHelperEntryPoint {
    fun preferencesHelper(): PreferencesHelper
    fun localeHelper(): LocaleHelper
}
