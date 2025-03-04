package com.example.middlecourseproject.domain.repository

interface TokenRepository {
    suspend fun getToken(): String?
    suspend fun saveUserAuth(token: String)
    suspend fun clearToken()

}