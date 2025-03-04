package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.TokenRepository
import android.util.Base64
import org.json.JSONObject
import javax.inject.Inject

class CheckAuthTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(): Boolean {
        val token = tokenRepository.getToken() ?: return false
        return isTokenValid(token)
    }

    private fun isTokenValid(token: String): Boolean {
        return try {
            val parts = token.split(".")
            if (parts.size != 3) return false

            val payloadSegment = parts[1]
            val decodedBytes = Base64.decode(payloadSegment, Base64.URL_SAFE or Base64.NO_WRAP)
            val payloadJson = String(decodedBytes)
            val jsonObject = JSONObject(payloadJson)
            if (!jsonObject.has("exp")) return false

            val exp = jsonObject.getLong("exp")
            val currentTime = System.currentTimeMillis() / 1000

            currentTime < exp
        } catch (e: Exception) {
            false
        }
    }
}