package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.domain.repository.LanguageRepository
import com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper
import com.example.middlecourseproject.data.local.sharedPreferences.LocaleHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LanguageRepositoryImpl @Inject constructor(
    private val preferencesHelper: PreferencesHelper,
    private val localeHelper: LocaleHelper
) : LanguageRepository {

    override suspend fun getLanguage(): String {
        return preferencesHelper.getLanguage()
    }

    override suspend fun saveLanguage(language: String) {
        preferencesHelper.saveLanguage(language)
        // Update locale as part of saving the new language.
        localeHelper.setLocale(language)
    }

    override suspend fun toggleLanguage(): String {
        val currentLang = getLanguage()
        val newLang = if (currentLang == "en") "ka" else "en"
        saveLanguage(newLang)
        return newLang
    }
}