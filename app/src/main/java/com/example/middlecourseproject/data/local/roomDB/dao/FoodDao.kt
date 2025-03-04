package com.example.middlecourseproject.data.local.roomDB.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recipes: List<RecipeEntity>)

    @Query("DELETE FROM recipes WHERE query = :query")
    suspend fun clearRecipes(query: String)

    @Query("SELECT * FROM recipes WHERE query = LOWER(:query) ORDER BY socialRank DESC")
    fun getRecipesPagingSource(query: String): PagingSource<Int, RecipeEntity>
}