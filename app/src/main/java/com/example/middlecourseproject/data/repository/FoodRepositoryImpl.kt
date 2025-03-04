package com.example.middlecourseproject.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.middlecourseproject.data.local.roomDB.database.AppDatabase
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.data.remote.FoodRemoteMediator
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.data.remote.services.FoodService
import com.example.middlecourseproject.data.utils.ApiHelper
import com.example.middlecourseproject.utils.NetworkUtil
import com.example.middlecourseproject.domain.mappers.toRecipe
import com.example.middlecourseproject.domain.models.Recipe
import com.example.middlecourseproject.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val apiHelper: ApiHelper,
    private val appDatabase: AppDatabase,
    private val networkUtil: NetworkUtil
) : FoodRepository {

    override suspend fun getFoods(query: String): Resource<FoodDto> {
        return apiHelper.handleHttpRequest {
            foodService.searchFoods(query)
        }
    }
    @OptIn(ExperimentalPagingApi::class)
    override fun getPagedFoods(query: String): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(pageSize = 4, enablePlaceholders = false),
            remoteMediator = FoodRemoteMediator(query, foodService, appDatabase, networkUtil),
            pagingSourceFactory = { appDatabase.foodDao().getRecipesPagingSource(query) }
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toRecipe()
            }
        }
    }
}