package com.example.middlecourseproject.data.local

import android.content.Context
import android.content.res.Configuration
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocaleHelper @Inject constructor(@ApplicationContext private val context: Context) {

    /**
     * Updates the locale using the injected Application context.
     * (Note: Depending on your API level, you may consider using
     * context.createConfigurationContext() for a more modern approach.)
     */
    fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        // This method is deprecated in newer API levels; consider alternative approaches if needed.
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    /**
     * Alternatively, if you need to update a given context’s configuration:
     */
    fun applyLocale(baseContext: Context, langCode: String): Context {
        val config = baseContext.resources.configuration
        val locale = Locale(langCode)
        Locale.setDefault(locale)
        config.setLocale(locale)
        return baseContext.createConfigurationContext(config)
    }
}
