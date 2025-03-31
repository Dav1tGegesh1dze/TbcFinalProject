package com.example.middlecourseproject.presentation.utils

import android.content.Context
import android.content.res.Configuration
import com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject

class StringProviderImpl @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val preferencesHelper: PreferencesHelper
) : StringProvider {
    override fun getString(resId: Int): String {
        val langCode = preferencesHelper.getLanguage()
        val locale = Locale(langCode)
        val config = Configuration(appContext.resources.configuration)
        config.setLocale(locale)
        val localizedContext = appContext.createConfigurationContext(config)
        return localizedContext.getString(resId)
    }


}