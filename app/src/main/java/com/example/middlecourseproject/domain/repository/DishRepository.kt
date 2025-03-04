package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.DishDto

interface DishRepository {
    suspend fun getDish(id: String): Resource<DishDto>

}