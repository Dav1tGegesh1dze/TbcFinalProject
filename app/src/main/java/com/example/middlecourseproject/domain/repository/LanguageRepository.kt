package com.example.middlecourseproject.domain.repository

interface LanguageRepository {
    suspend fun getLanguage(): String
    suspend fun saveLanguage(language: String)
    suspend fun toggleLanguage(): String
}