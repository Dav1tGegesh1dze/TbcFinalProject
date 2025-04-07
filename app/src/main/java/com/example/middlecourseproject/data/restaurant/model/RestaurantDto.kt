package com.example.middlecourseproject.data.restaurant.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantDto(
    val id: String,
    val name: NameDto,
    @SerialName("categoryId")
    val categoryId: String,
    @SerialName("categoryName")
    val categoryName: NameDto,
    val categoryImage: String,
    val rating: Double,
    val mainImage: String,
    val additionalImages: List<String>,
    val location: LocationDto,
    val fullDescription: NameDto,
    val menu: List<MenuCategoryDto>
)

@Serializable
data class NameDto(
    val en: String,
    val ka: String
)

@Serializable
data class LocationDto(
    val address: NameDto,
    val city: NameDto,
    val coordinates: CoordinatesDto
)

@Serializable
data class CoordinatesDto(
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class MenuCategoryDto(
    val categoryId: String,
    val categoryName: NameDto,
    val dishes: List<DishDto>
)

@Serializable
data class DishDto(
    val id: String,
    val name: NameDto,
    val price: Double,
    val ingredients: List<NameDto>,
    val deliveryTime: Int,
    val image: String
)
