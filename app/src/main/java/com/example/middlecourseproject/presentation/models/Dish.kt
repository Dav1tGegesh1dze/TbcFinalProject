package com.example.middlecourseproject.presentation.models

data class Dish (
    val publisher: String,
    val ingredients: List<String>,
    val sourceUrl: String,
    val imageUrl: String,
    val socialRank: Int,
    val title: String
)
