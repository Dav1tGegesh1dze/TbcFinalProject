package com.example.middlecourseproject.data.local.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import java.util.Locale

@Singleton
class PreferencesHelper @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        private const val PREFS_NAME = "MyPrefs"
        private const val LANGUAGE_KEY = "language_key"
    }

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveLanguage(langCode: String) {
        prefs.edit().putString(LANGUAGE_KEY, langCode).apply()
    }

    fun getLanguage(): String {
        return prefs.getString(LANGUAGE_KEY, null) ?: getDefaultLanguageBasedOnSystem()
    }

    private fun getDefaultLanguageBasedOnSystem(): String {
        val systemLanguage = Locale.getDefault().language
        return if (systemLanguage.equals("ka", ignoreCase = true)) "ka" else "en"
    }
}
