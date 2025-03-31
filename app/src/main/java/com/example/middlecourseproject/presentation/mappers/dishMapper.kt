package com.example.middlecourseproject.presentation.mappers

import com.example.middlecourseproject.data.remote.dtos.DishDto
import com.example.middlecourseproject.domain.models.DishDomain
import com.example.middlecourseproject.presentation.models.Dish
import kotlin.math.roundToInt

fun DishDomain.toDish(): Dish {
    return Dish(
        publisher = this.publisher,
        ingredients = this.ingredients,
        sourceUrl = this.sourceUrl,
        imageUrl = this.imageUrl,
        socialRank = this.socialRank,
        title = this.title
    )
}