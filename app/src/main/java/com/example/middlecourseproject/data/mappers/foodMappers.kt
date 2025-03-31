package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity
import com.example.middlecourseproject.domain.models.Recipe

fun String.truncate(maxLength: Int): String =
    if (this.length > maxLength) this.take(maxLength) + "..." else this




fun RecipeEntity.toRecipe(): Recipe = Recipe(
    publisher = publisher,
    title = title,
    sourceUrl = sourceUrl,
    recipeId = recipeId,
    imageUrl = imageUrl,
    socialRank = socialRank,
    publisherUrl = publisherUrl
)