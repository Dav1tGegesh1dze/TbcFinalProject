package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodDto(
    val count: Int,
    val recipes: List<RecipeDto>
)

@Serializable
data class RecipeDto(
    val publisher: String,
    val title: String,
    @SerialName("source_url")
    val sourceUrl: String,
    @SerialName("recipe_id")
    val recipeId: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("social_rank")
    val socialRank: Double,
    @SerialName("publisher_url")
    val publisherUrl: String
)
