package com.example.middlecourseproject.presentation.dish.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.cart.usecase.AddToCartUseCase
import com.example.middlecourseproject.domain.cart.usecase.GetCartItemCountUseCase
import com.example.middlecourseproject.domain.restaurant.model.Dish
import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DishesState(
    val restaurant: Restaurant? = null,
    val isLoading: Boolean = true,
    val error: String? = null,
    val cartItemCount: Int = 0,
    val message: String? = null
)

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getRestaurantByIdUseCase: GetRestaurantByIdUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val getCartItemCountUseCase: GetCartItemCountUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DishesState())
    val state: StateFlow<DishesState> = _state

    init {
        observeCartCount()
    }

    private fun observeCartCount() {
        getCartItemCountUseCase().onEach { count ->
            _state.value = _state.value.copy(cartItemCount = count)
        }.launchIn(viewModelScope)
    }

    fun loadRestaurantDetails(restaurantId: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                getRestaurantByIdUseCase(restaurantId).collect { restaurant ->
                    _state.value = _state.value.copy(
                        restaurant = restaurant,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load restaurant details"
                )
            }
        }
    }

    fun addToCart(dish: Dish) {
        viewModelScope.launch {
            val restaurant = _state.value.restaurant
            if (restaurant != null) {
                try {
                    addToCartUseCase(dish, restaurant)
                    showMessage("${dish.name} added to cart")
                } catch (e: Exception) {
                    showMessage("Failed to add to cart: ${e.message}")
                }
            }
        }
    }

    private fun showMessage(message: String) {
        _state.value = _state.value.copy(message = message)
        viewModelScope.launch {
            kotlinx.coroutines.delay(2000)
            _state.value = _state.value.copy(message = null)
        }
    }
}