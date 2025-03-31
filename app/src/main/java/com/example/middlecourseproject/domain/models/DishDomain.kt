package com.example.middlecourseproject.domain.models

data class DishDomain(
    val publisher: String,
    val ingredients: List<String>,
    val sourceUrl: String,
    val imageUrl: String,
    val socialRank: Int,
    val title: String
)