package com.example.middlecourseproject.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.example.middlecourseproject.data.local.roomDB.database.AppDatabase
import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity
import com.example.middlecourseproject.data.remote.services.FoodService
import com.example.middlecourseproject.utils.NetworkUtil
import com.example.middlecourseproject.domain.mappers.truncate
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import java.io.IOException
import kotlin.math.roundToInt

@OptIn(ExperimentalPagingApi::class)
class FoodRemoteMediator(
    private val query: String,
    private val foodService: FoodService,
    private val appDatabase: AppDatabase,
    private val networkUtil: NetworkUtil
) : RemoteMediator<Int, RecipeEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RecipeEntity>
    ): MediatorResult {
        try {
            val standardizedQuery = query.trim().lowercase()

            // Check if offline
            if (!networkUtil.isNetworkAvailableFlow.first()) {
                // Offline: Rely on database data, end pagination
                return MediatorResult.Success(endOfPaginationReached = true)
            }

            // Online: Call API for fresh data
            val response = foodService.searchFoods(standardizedQuery)
            if (!response.isSuccessful) {
                // API error: Don’t modify database, return error for UI to handle
                return MediatorResult.Error(HttpException(response))
            }

            val foodDto = response.body()
            if (foodDto == null) {
                // Null response body: Treat as error, don’t modify database
                return MediatorResult.Error(Exception("No data"))
            }

            val recipeEntities = foodDto.recipes.map { recipeDto ->
                RecipeEntity(
                    recipeId = recipeDto.recipeId,
                    query = standardizedQuery,
                    publisher = recipeDto.publisher.truncate(10),
                    title = recipeDto.title.truncate(10),
                    sourceUrl = recipeDto.sourceUrl,
                    imageUrl = recipeDto.imageUrl,
                    socialRank = recipeDto.socialRank.roundToInt(),
                    publisherUrl = recipeDto.publisherUrl
                )
            }

            // Only clear and insert if API returns non-empty recipe list
            appDatabase.withTransaction {
                if (recipeEntities.isNotEmpty()) {
                    appDatabase.foodDao().clearRecipes(standardizedQuery)
                    appDatabase.foodDao().insertAll(recipeEntities)
                }
            }

            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: IOException) {
            // Network-related error: Don’t modify database
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            // HTTP error: Don’t modify database
            return MediatorResult.Error(e)
        }
    }
}