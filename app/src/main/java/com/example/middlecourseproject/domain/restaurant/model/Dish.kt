package com.example.middlecourseproject.domain.restaurant.model


data class Dish(
    val id: String,
    val name: String,
    val nameKa: String,
    val price: Double,
    val ingredients: List<String>,
    val ingredientsKa: List<String>,
    val deliveryTime: Int,
    val image: String
)