package com.example.middlecourseproject.domain.useCases

import android.util.Base64
import com.example.middlecourseproject.domain.repository.TokenRepository
import org.json.JSONObject
import javax.inject.Inject

class ClearTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(): Unit {
        tokenRepository.clearToken()
    }

}