package com.example.middlecourseproject.domain.mappers

import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.data.remote.dtos.RecipeDto
import com.example.middlecourseproject.domain.models.Food
import com.example.middlecourseproject.domain.models.Recipe

import kotlin.math.roundToInt

// Helper function to truncate a string to a maximum length, appending "..." if needed.
fun String.truncate(maxLength: Int): String =
    if (this.length > maxLength) this.take(maxLength) + "..." else this

// Map RecipeDto to domain Recipe.
// Here, both title and publisher are truncated to the first 10 characters (if longer)
// and the socialRank is rounded to an integer.
fun RecipeDto.toRecipe(): Recipe = Recipe(
    publisher = publisher.truncate(10),
    title = title.truncate(10),
    sourceUrl = sourceUrl,
    recipeId = recipeId,
    imageUrl = imageUrl,
    socialRank = socialRank.roundToInt(),
    publisherUrl = publisherUrl
)

// Map FoodDto to domain Food by mapping each RecipeDto.
fun FoodDto.toFood(): Food = Food(
    count = count,
    recipes = recipes.map { it.toRecipe() }
)
fun RecipeEntity.toRecipe(): Recipe = Recipe(
    publisher = publisher,
    title = title,
    sourceUrl = sourceUrl,
    recipeId = recipeId,
    imageUrl = imageUrl,
    socialRank = socialRank,
    publisherUrl = publisherUrl
)