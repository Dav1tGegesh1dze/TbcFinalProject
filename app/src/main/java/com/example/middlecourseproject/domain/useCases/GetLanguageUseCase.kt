package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.LanguageRepository
import javax.inject.Inject

class GetLanguageUseCase @Inject constructor(
    private val languageRepository: LanguageRepository
) {
    suspend operator fun invoke(): String = languageRepository.getLanguage()
}