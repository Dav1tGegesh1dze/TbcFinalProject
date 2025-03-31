package com.example.middlecourseproject.domain.repository

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.domain.models.DishDomain

interface DishRepository {
    suspend fun getDish(id: String): Resource<DishDomain>

}