package com.example.middlecourseproject.domain.repository

import androidx.paging.PagingData
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface DishRepository {
    suspend fun getDish(id: String): Resource<DishDto>

}