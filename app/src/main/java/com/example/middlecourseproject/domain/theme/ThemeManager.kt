package com.example.middlecourseproject.domain.theme

import android.util.Log
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
    companion object {
        private const val THEME_KEY = "app_theme"
    }

    private val _isDarkMode = MutableStateFlow(isDarkModeActive())
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    fun isDarkModeActive(): Boolean {
        return preferencesHelper.getBooleanValue(THEME_KEY, false)
    }

    fun toggleTheme(): Boolean {
        Log.d("ThemeManager", "Toggle theme called. Current mode: ${isDarkModeActive()}")
        val isDark = !isDarkModeActive()

        // Save the preference
        preferencesHelper.saveBooleanValue(THEME_KEY, isDark)

        // Apply theme change
        try {
            val mode = if (isDark) {
                Log.d("ThemeManager", "Setting to dark mode")
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                Log.d("ThemeManager", "Setting to light mode")
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(mode)
        } catch (e: Exception) {
            Log.e("ThemeManager", "Error applying theme", e)
        }

        _isDarkMode.value = isDark
        return isDark
    }

    fun applyTheme() {
        Log.d("ThemeManager", "Apply theme called. Current mode: ${isDarkModeActive()}")
        try {
            val mode = if (isDarkModeActive()) {
                Log.d("ThemeManager", "Applying dark mode")
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                Log.d("ThemeManager", "Applying light mode")
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(mode)
        } catch (e: Exception) {
            Log.e("ThemeManager", "Error applying theme", e)
        }
    }
}