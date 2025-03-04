package com.example.middlecourseproject.data.local.roomDB.entity

import androidx.room.Entity

@Entity(
    tableName = "recipes",
    primaryKeys = ["recipeId", "query"]
)
data class RecipeEntity(
    val recipeId: String,
    val query: String,
    val publisher: String,
    val title: String,
    val sourceUrl: String,
    val imageUrl: String,
    val socialRank: Int,
    val publisherUrl: String
)