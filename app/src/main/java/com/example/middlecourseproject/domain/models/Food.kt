package com.example.middlecourseproject.domain.models


data class Food(
    val count: Int,
    val recipes: List<Recipe>
)

data class Recipe(
    val publisher: String,
    val title: String,
    val sourceUrl: String,
    val recipeId: String,
    val imageUrl: String,
    val socialRank: Int,
    val publisherUrl: String
)
