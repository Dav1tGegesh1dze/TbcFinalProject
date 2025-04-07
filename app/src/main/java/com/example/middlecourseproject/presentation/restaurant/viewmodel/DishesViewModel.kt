package com.example.middlecourseproject.presentation.restaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantByIdUseCase
import com.example.middlecourseproject.presentation.restaurant.state.DishesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getRestaurantByIdUseCase: GetRestaurantByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DishesState())
    val state: StateFlow<DishesState> = _state

    fun loadRestaurantDetails(restaurantId: String) {
        _state.update { it.copy(isLoading = true) }

        getRestaurantByIdUseCase(restaurantId)
            .onEach { restaurant ->
                _state.update {
                    it.copy(
                        restaurant = restaurant,
                        isLoading = false
                    )
                }
            }
            .catch { error ->
                _state.update {
                    it.copy(
                        error = error.message,
                        isLoading = false
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}