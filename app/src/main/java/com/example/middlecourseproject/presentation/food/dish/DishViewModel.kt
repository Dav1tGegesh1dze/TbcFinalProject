package com.example.middlecourseproject.presentation.food.dish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.DishDomain
import com.example.middlecourseproject.domain.useCases.GetDishUseCase
import com.example.middlecourseproject.presentation.mappers.toDish
import com.example.middlecourseproject.presentation.models.Dish
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(
    private val getDishUseCase: GetDishUseCase,

) : ViewModel() {

    private val _dish = MutableStateFlow<Resource<Dish>>(Resource.Idle)
    val dish: StateFlow<Resource<Dish>> = _dish

    fun fetchDish(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _dish.value = Resource.Loading

            when (val result = getDishUseCase(id)) {
                is Resource.Success ->{
                    _dish.value = Resource.Success(result.data.toDish())
                }
                is Resource.Error -> {

                    _dish.value = Resource.Error(result.message)
                }
                is Resource.Loading ->{
                    _dish.value = Resource.Loading
                }
                is Resource.Idle ->{
                    _dish.value = Resource.Idle
                }
            }

        }
    }

}