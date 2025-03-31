package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.DishDomain
import com.example.middlecourseproject.domain.repository.DishRepository
import javax.inject.Inject

class GetDishUseCase @Inject constructor (
    private val dishRepository: DishRepository
) {
    suspend operator fun invoke(id: String): Resource<DishDomain> {
        return dishRepository.getDish(id)
    }
}