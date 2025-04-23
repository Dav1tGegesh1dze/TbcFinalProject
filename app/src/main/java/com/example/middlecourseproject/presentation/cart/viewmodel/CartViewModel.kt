package com.example.middlecourseproject.presentation.cart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.cart.CartItem
import com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase
import com.example.middlecourseproject.domain.cart.usecase.GetCartItemsUseCase
import com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase
import com.example.middlecourseproject.domain.cart.usecase.RemoveFromCartUseCase
import com.example.middlecourseproject.domain.cart.usecase.UpdateCartItemQuantityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CartState(
    val cartItems: List<CartItem> = emptyList(),
    val cartTotal: Double = 0.0,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val getCartTotalUseCase: GetCartTotalUseCase,
    private val updateCartItemQuantityUseCase: UpdateCartItemQuantityUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val clearCartUseCase: ClearCartUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CartState(isLoading = true))
    val state: StateFlow<CartState> = _state

    // Use a class property instead of a constructor parameter
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    init {
        loadCartData()
    }

    private fun loadCartData() {
        combine(
            getCartItemsUseCase().flowOn(dispatcher),
            getCartTotalUseCase().flowOn(dispatcher)
        ) { items, total ->
            _state.value = _state.value.copy(
                cartItems = items,
                cartTotal = total,
                isLoading = false,
                error = null
            )
        }
            .flowOn(dispatcher)
            .catch { e ->
                _state.value = _state.value.copy(
                    error = e.message ?: "Unknown error occurred",
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)
    }

    fun increaseQuantity(dishId: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val cartItem = _state.value.cartItems.find { it.dishId == dishId }
                cartItem?.let {
                    updateCartItemQuantityUseCase(dishId, it.quantity + 1)
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = "Failed to update quantity: ${e.message}"
                )
            }
        }
    }

    fun decreaseQuantity(dishId: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val cartItem = _state.value.cartItems.find { it.dishId == dishId }
                cartItem?.let {
                    if (it.quantity > 1) {
                        updateCartItemQuantityUseCase(dishId, it.quantity - 1)
                    } else {
                        removeFromCartUseCase(dishId)
                    }
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = "Failed to update quantity: ${e.message}"
                )
            }
        }
    }

    fun removeItem(dishId: String) {
        viewModelScope.launch(dispatcher) {
            try {
                removeFromCartUseCase(dishId)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = "Failed to remove item: ${e.message}"
                )
            }
        }
    }

    fun clearCart() {
        viewModelScope.launch(dispatcher) {
            try {
                clearCartUseCase()
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = "Failed to clear cart: ${e.message}"
                )
            }
        }
    }
}