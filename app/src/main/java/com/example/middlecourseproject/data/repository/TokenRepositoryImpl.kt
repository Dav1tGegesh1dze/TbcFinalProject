package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.domain.repository.TokenRepository
import com.example.middlecourseproject.data.local.DataStoreManager
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenRepositoryImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : TokenRepository {
    override suspend fun getToken(): String? {
        return dataStoreManager.getToken().firstOrNull()
    }
    override suspend fun saveUserAuth(token: String) {
        dataStoreManager.saveToken(token)
    }

}