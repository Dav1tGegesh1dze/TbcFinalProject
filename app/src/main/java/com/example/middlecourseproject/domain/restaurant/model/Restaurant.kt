package com.example.middlecourseproject.domain.restaurant.model

data class Restaurant(
    val id: String,
    val name: String,
    val nameKa: String,
    val categoryId: String,
    val categoryName: String,
    val categoryNameKa: String,
    val rating: Double,
    val mainImage: String,
    val categoryImage: String,
    val additionalImages: List<String>,
    val location: Location,
    val fullDescription: String,
    val fullDescriptionKa: String,
    val menu: List<MenuCategory>
) {
    data class Location(
        val address: String,
        val addressKa: String,
        val city: String,
        val cityKa: String,
        val latitude: Double,
        val longitude: Double
    )

    data class MenuCategory(
        val categoryId: String,
        val categoryName: String,
        val categoryNameKa: String,
        val dishes: List<Dish>
    )
}
