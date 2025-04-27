package com.example.middlecourseproject.domain.search

import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchHelper @Inject constructor() {

    /**
     * Extracts popular cuisines and food types from restaurants
     */
    fun generatePopularSearchTerms(restaurants: List<Restaurant>): List<String> {
        val searchTerms = mutableSetOf<String>()

        // Add category names
        restaurants.forEach { restaurant ->
            searchTerms.add(restaurant.categoryName)
        }

        // Add common dish types from restaurant names
        val commonDishTypes = listOf(
            "Sushi", "Pizza", "Burger", "Coffee", "Sandwich", "Salad",
            "Dessert", "Wings", "Noodles", "Italian", "Asian", "Georgian",
            "Khinkali", "Shaurma", "Pasta", "Steak", "Seafood", "Vegan",
            "Vegetarian", "Breakfast", "Brunch", "Lunch", "Dinner"
        )

        commonDishTypes.forEach { dishType ->
            // Only add if there's at least one restaurant that matches this type
            val exists = restaurants.any { restaurant ->
                restaurant.name.contains(dishType, ignoreCase = true) ||
                        restaurant.categoryName.contains(dishType, ignoreCase = true) ||
                        restaurant.menu.any { menuCategory ->
                            menuCategory.dishes.any { dish ->
                                dish.name.contains(dishType, ignoreCase = true)
                            }
                        }
            }

            if (exists) {
                searchTerms.add(dishType)
            }
        }

        // Include additional popular food types from the image
        val additionalTerms = listOf(
            "Sushi", "Asian", "Pizza", "Burger", "Pet",
            "Grocery", "Wings", "Salad", "Alcohol", "Italian",
            "Coffee", "Sandwich", "Dessert", "Georgian",
            "Khinkali", "Noodles", "Shaurma", "Pharmacy",
            "Wrap", "Flowers", "Health & Beauty", "Pet supply",
            "Gifts"
        )

        // Add these terms to our set
        searchTerms.addAll(additionalTerms)

        // Return sorted list with duplicates removed
        return searchTerms.toList().sorted()
    }

    /**
     * Filter restaurants based on search query
     */
    fun filterRestaurants(restaurants: List<Restaurant>, query: String): List<Restaurant> {
        if (query.isBlank()) return emptyList()

        val lowercaseQuery = query.lowercase().trim()

        return restaurants.filter { restaurant ->
            // Search in restaurant name
            if (restaurant.name.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            // Search in category name
            if (restaurant.categoryName.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            // Search in location
            if (restaurant.location.address.lowercase().contains(lowercaseQuery) ||
                restaurant.location.city.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            // Search in menu categories
            val menuCategoryMatch = restaurant.menu.any { menuCategory ->
                menuCategory.categoryName.lowercase().contains(lowercaseQuery)
            }

            if (menuCategoryMatch) {
                return@filter true
            }

            // Search in dish names
            val dishMatch = restaurant.menu.any { menuCategory ->
                menuCategory.dishes.any { dish ->
                    dish.name.lowercase().contains(lowercaseQuery)
                }
            }

            if (dishMatch) {
                return@filter true
            }

            // Search in ingredient lists
            val ingredientMatch = restaurant.menu.any { menuCategory ->
                menuCategory.dishes.any { dish ->
                    dish.ingredients.any { ingredient ->
                        ingredient.lowercase().contains(lowercaseQuery)
                    }
                }
            }

            ingredientMatch
        }
    }
}