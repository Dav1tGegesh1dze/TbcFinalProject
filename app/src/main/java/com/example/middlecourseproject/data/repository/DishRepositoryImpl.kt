package com.example.middlecourseproject.data.repository


import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.data.remote.services.DishService
import com.example.middlecourseproject.data.utils.ApiHelper

import com.example.middlecourseproject.domain.repository.DishRepository

import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    private val dishService: DishService,
    private val apiHelper: ApiHelper,

) : DishRepository {

    override suspend fun getDish(id: String): Resource<DishDto> {
        return apiHelper.handleHttpRequest {
            dishService.getDish(id)
        }
    }

}