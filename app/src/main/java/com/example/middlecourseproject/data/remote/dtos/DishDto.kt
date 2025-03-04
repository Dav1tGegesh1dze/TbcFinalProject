package com.example.middlecourseproject.data.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DishDto(
    val recipe: ExactRecipeDto
)

@Serializable
data class ExactRecipeDto(
    val publisher: String,
    val ingredients: List<String>,
    @SerialName("source_url")
    val sourceUrl: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("social_rank")
    val socialRank: Double,
    val title: String
)