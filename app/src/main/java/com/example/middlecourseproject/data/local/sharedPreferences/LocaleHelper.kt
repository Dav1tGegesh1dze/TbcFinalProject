package com.example.middlecourseproject.data.local.sharedPreferences

import android.content.Context
import android.content.res.Configuration
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocaleHelper @Inject constructor(@ApplicationContext private val context: Context) {


    fun applyLocale(baseContext: Context, langCode: String): Context {
        val config = baseContext.resources.configuration
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        config.setLocale(locale)
        return baseContext.createConfigurationContext(config)
    }
}
