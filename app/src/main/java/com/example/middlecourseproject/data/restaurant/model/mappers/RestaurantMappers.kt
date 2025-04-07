package com.example.middlecourseproject.data.restaurant.model.mappers

import com.example.middlecourseproject.data.restaurant.model.DishDto
import com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto
import com.example.middlecourseproject.data.restaurant.model.RestaurantDto
import com.example.middlecourseproject.domain.restaurant.model.Category
import com.example.middlecourseproject.domain.restaurant.model.Dish
import com.example.middlecourseproject.domain.restaurant.model.Restaurant

fun RestaurantDto.toDomain(): Restaurant {
    return Restaurant(
        id = this.id,
        name = this.name.en,
        nameKa = this.name.ka,
        categoryId = this.categoryId,
        categoryName = this.categoryName.en,
        categoryNameKa = this.categoryName.ka,
        categoryImage = this.categoryImage,
        rating = this.rating,
        mainImage = this.mainImage,
        additionalImages = this.additionalImages,
        location = Restaurant.Location(
            address = this.location.address.en,
            addressKa = this.location.address.ka,
            city = this.location.city.en,
            cityKa = this.location.city.ka,
            latitude = this.location.coordinates.latitude,
            longitude = this.location.coordinates.longitude
        ),
        fullDescription = this.fullDescription.en,
        fullDescriptionKa = this.fullDescription.ka,
        menu = this.menu.map { it.toDomain() }
    )
}

fun MenuCategoryDto.toDomain(): Restaurant.MenuCategory {
    return Restaurant.MenuCategory(
        categoryId = this.categoryId,
        categoryName = this.categoryName.en,
        categoryNameKa = this.categoryName.ka,
        dishes = this.dishes.map { it.toDomain() }
    )
}

fun DishDto.toDomain(): Dish {
    return Dish(
        id = this.id,
        name = this.name.en,
        nameKa = this.name.ka,
        price = this.price,
        ingredients = this.ingredients.map { it.en },
        ingredientsKa = this.ingredients.map { it.ka },
        deliveryTime = this.deliveryTime,
        image = this.image
    )
}

fun List<RestaurantDto>.extractCategories(): List<Category> {
    return this.map {
        Category(
            id = it.categoryId,
            name = it.categoryName.en,
            nameKa = it.categoryName.ka,
            imageUrl = it.categoryImage
        )
    }.distinctBy { it.id }
}