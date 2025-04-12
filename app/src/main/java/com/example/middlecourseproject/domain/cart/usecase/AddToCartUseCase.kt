package com.example.middlecourseproject.domain.cart.usecase

import com.example.middlecourseproject.domain.cart.CartItem
import com.example.middlecourseproject.domain.cart.repository.CartRepository
import com.example.middlecourseproject.domain.restaurant.model.Dish
import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(dish: Dish, restaurant: Restaurant) {
        val cartItem = CartItem(
            dishId = dish.id,
            restaurantId = restaurant.id,
            name = dish.name,
            nameKa = dish.nameKa,
            price = dish.price,
            image = dish.image,
            quantity = 1
        )
        cartRepository.addItemToCart(cartItem)
    }
}