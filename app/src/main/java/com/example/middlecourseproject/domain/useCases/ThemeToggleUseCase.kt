package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.theme.ThemeManager
import javax.inject.Inject

class ThemeToggleUseCase @Inject constructor(
    private val themeManager: ThemeManager
) {
    operator fun invoke(): Boolean {
        return themeManager.toggleTheme()
    }
}

class GetThemeUseCase @Inject constructor(
    private val themeManager: ThemeManager
) {
    operator fun invoke(): Boolean {
        return themeManager.isDarkModeActive()
    }
}