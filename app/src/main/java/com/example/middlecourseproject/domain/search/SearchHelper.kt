package com.example.middlecourseproject.domain.search

import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchHelper @Inject constructor() {
    fun generatePopularSearchTerms(restaurants: List<Restaurant>): List<String> {
        val searchTerms = mutableSetOf<String>()


        restaurants.forEach { restaurant ->
            searchTerms.add(restaurant.categoryName)
        }

        val commonDishTypes = listOf(
            "Sushi", "Pizza", "Burger", "Coffee", "Sandwich", "Salad",
            "Dessert", "Wings", "Noodles", "Italian", "Asian", "Georgian",
            "Khinkali", "Shaurma", "Pasta", "Steak", "Seafood", "Vegan",
            "Vegetarian", "Breakfast", "Brunch", "Lunch", "Dinner"
        )

        commonDishTypes.forEach { dishType ->
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

        val additionalTerms = listOf(
            "Sushi", "Asian", "Pizza", "Burger", "Pet",
            "Grocery", "Wings", "Salad", "Alcohol", "Italian",
            "Coffee", "Sandwich", "Dessert", "Georgian",
            "Khinkali", "Noodles", "Shaurma", "Pharmacy",
            "Wrap", "Flowers", "Health & Beauty", "Pet supply",
            "Gifts"
        )


        searchTerms.addAll(additionalTerms)

        return searchTerms.toList().sorted()
    }


    fun filterRestaurants(restaurants: List<Restaurant>, query: String): List<Restaurant> {
        if (query.isBlank()) return emptyList()

        val lowercaseQuery = query.lowercase().trim()

        return restaurants.filter { restaurant ->
            if (restaurant.name.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            if (restaurant.categoryName.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            if (restaurant.location.address.lowercase().contains(lowercaseQuery) ||
                restaurant.location.city.lowercase().contains(lowercaseQuery)) {
                return@filter true
            }

            val menuCategoryMatch = restaurant.menu.any { menuCategory ->
                menuCategory.categoryName.lowercase().contains(lowercaseQuery)
            }

            if (menuCategoryMatch) {
                return@filter true
            }

            val dishMatch = restaurant.menu.any { menuCategory ->
                menuCategory.dishes.any { dish ->
                    dish.name.lowercase().contains(lowercaseQuery)
                }
            }

            if (dishMatch) {
                return@filter true
            }

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