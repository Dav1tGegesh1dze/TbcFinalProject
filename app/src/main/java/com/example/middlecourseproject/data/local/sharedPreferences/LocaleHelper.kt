package com.example.middlecourseproject.data.local.sharedPreferences

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocaleHelper @Inject constructor(@ApplicationContext private val context: Context) {


    fun applyLocale(context: Context, languageCode: String): Context {
        Log.d("LocaleHelper", "Applying locale: $languageCode")

        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        val oldLocale = config.locales.get(0).language
        config.setLocale(locale)

        val newContext = context.createConfigurationContext(config)
        val newLocale = newContext.resources.configuration.locales.get(0).language

        Log.d("LocaleHelper", "Locale changed from $oldLocale to $newLocale")

        return newContext
    }
}
