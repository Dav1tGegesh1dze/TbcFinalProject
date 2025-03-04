package com.example.middlecourseproject.domain.useCases

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.mappers.toDish
import com.example.middlecourseproject.domain.models.Dish
import com.example.middlecourseproject.domain.repository.DishRepository
import javax.inject.Inject

class GetDishUseCase @Inject constructor (
    private val dishRepository: DishRepository
){
    suspend operator fun invoke(id: String): Resource<Dish> {
        return when (val result = dishRepository.getDish(id)) {
            is Resource.Success -> {
                Resource.Success(result.data.toDish())
            }
            is Resource.Error -> Resource.Error(result.message)
            is Resource.Loading -> Resource.Loading
            is Resource.Idle -> Resource.Idle
        }
    }
}