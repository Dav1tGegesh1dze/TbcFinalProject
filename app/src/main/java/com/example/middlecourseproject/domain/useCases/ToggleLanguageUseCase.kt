package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.LanguageRepository
import javax.inject.Inject

class ToggleLanguageUseCase @Inject constructor(
    private val languageRepository: LanguageRepository
) {
    suspend operator fun invoke(): String {
        return languageRepository.toggleLanguage()
    }
}