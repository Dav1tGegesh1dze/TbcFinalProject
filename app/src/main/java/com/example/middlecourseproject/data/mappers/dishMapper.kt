package com.example.middlecourseproject.data.mappers

import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.domain.models.DishDomain
import kotlin.math.roundToInt

fun DishDto.toDishDomain(): DishDomain {
    return DishDomain(
        publisher = this.recipe.publisher,
        ingredients = this.recipe.ingredients,
        sourceUrl = this.recipe.sourceUrl,
        imageUrl = this.recipe.imageUrl,
        socialRank = this.recipe.socialRank.roundToInt(),
        title = this.recipe.title
    )
}