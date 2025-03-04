package com.example.middlecourseproject.presentation.food.dish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.Dish
import com.example.middlecourseproject.domain.useCases.GetDishUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(
    private val getDishUseCase: GetDishUseCase
) : ViewModel() {

    private val _dish = MutableStateFlow<Resource<Dish>>(Resource.Idle)
    val dish: StateFlow<Resource<Dish>> = _dish

    fun fetchDish(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _dish.value = Resource.Loading
            _dish.value = getDishUseCase(id)

        }
    }

}