package com.example.middlecourseproject.data.repository


import com.example.middlecourseproject.data.mappers.toDishDomain
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.services.DishService
import com.example.middlecourseproject.data.utils.ApiHelper
import com.example.middlecourseproject.domain.models.DishDomain

import com.example.middlecourseproject.domain.repository.DishRepository

import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    private val dishService: DishService,
    private val apiHelper: ApiHelper,

) : DishRepository {

    override suspend fun getDish(id: String): Resource<DishDomain> {
        return when ( val result =  apiHelper.handleHttpRequest {
            dishService.getDish(id)
        } ) {
            is Resource.Success ->{
                Resource.Success(result.data.toDishDomain())
            }
            is Resource.Error -> {
                Resource.Error(result.message)
            }
            is Resource.Loading ->{
                Resource.Loading
            }
            is Resource.Idle ->{
                Resource.Idle
            }
        }
    }

}