package com.example.middlecourseproject.domain.mappers


import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.domain.models.Dish
import kotlin.math.roundToInt

fun DishDto.toDish(): Dish {
    return Dish(
        publisher = this.recipe.publisher,
        ingredients = this.recipe.ingredients,
        sourceUrl = this.recipe.sourceUrl,
        imageUrl = this.recipe.imageUrl,
        socialRank = this.recipe.socialRank.roundToInt(),
        title = this.recipe.title
    )
}