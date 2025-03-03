package com.example.middlecourseproject.domain.repository

import androidx.paging.PagingData
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun getFoods(query: String): Resource<FoodDto>
    fun getPagedFoods(query: String): Flow<PagingData<Recipe>>

}