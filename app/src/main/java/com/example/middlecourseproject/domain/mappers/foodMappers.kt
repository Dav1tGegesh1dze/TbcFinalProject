package com.example.middlecourseproject.domain.mappers

import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity
import com.example.middlecourseproject.data.remote.dtos.FoodDto
import com.example.middlecourseproject.data.remote.dtos.RecipeDto
import com.example.middlecourseproject.domain.models.Food
import com.example.middlecourseproject.domain.models.Recipe

import kotlin.math.roundToInt

fun String.truncate(maxLength: Int): String =
    if (this.length > maxLength) this.take(maxLength) + "..." else this


fun RecipeDto.toRecipe(): Recipe = Recipe(
    publisher = publisher.truncate(10),
    title = title.truncate(10),
    sourceUrl = sourceUrl,
    recipeId = recipeId,
    imageUrl = imageUrl,
    socialRank = socialRank.roundToInt(),
    publisherUrl = publisherUrl
)

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