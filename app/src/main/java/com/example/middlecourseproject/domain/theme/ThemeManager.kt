package com.example.middlecourseproject.domain.theme

import androidx.appcompat.app.AppCompatDelegate
import com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeManager @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) {
    private val _isDarkMode = MutableStateFlow(isDarkModeActive())
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    fun isDarkModeActive(): Boolean {
        return preferencesHelper.isDarkThemeEnabled()
    }

    fun toggleTheme(): Boolean {
        val isDark = !isDarkModeActive()
        preferencesHelper.saveThemeMode(isDark)

        val mode = if (isDark) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(mode)
        _isDarkMode.value = isDark
        return isDark
    }

    fun applyTheme() {
        val mode = if (isDarkModeActive()) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
        _isDarkMode.value = isDarkModeActive()
    }
}