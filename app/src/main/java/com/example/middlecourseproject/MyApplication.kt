package com.example.middlecourseproject

import android.app.Application
import com.example.middlecourseproject.domain.theme.ThemeManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var themeManager: ThemeManager

    override fun onCreate() {
        super.onCreate()

        // Apply the theme based on saved preferences
        themeManager.applyTheme()
    }
}