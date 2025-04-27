package com.example.middlecourseproject.domain.restaurant.usecase

import com.example.middlecourseproject.domain.restaurant.model.AdBanner
import com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAdBannersUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(): Flow<List<AdBanner>> {
        return repository.getAdBanners()
    }
}