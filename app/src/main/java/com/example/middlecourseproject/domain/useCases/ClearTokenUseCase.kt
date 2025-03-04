package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.repository.TokenRepository
import javax.inject.Inject

class ClearTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(): Unit {
        tokenRepository.clearToken()
    }

}