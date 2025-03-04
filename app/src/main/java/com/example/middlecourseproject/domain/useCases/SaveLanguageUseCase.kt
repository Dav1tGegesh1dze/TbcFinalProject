package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.LanguageRepository
import javax.inject.Inject

class SaveLanguageUseCase @Inject constructor(
    private val languageRepository: LanguageRepository
) {
    suspend operator fun invoke(language: String) {
        languageRepository.saveLanguage(language)
    }
}