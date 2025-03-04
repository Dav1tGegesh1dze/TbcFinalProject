package com.example.middlecourseproject.presentation.food.home



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.Food
import com.example.middlecourseproject.domain.models.Recipe
import com.example.middlecourseproject.domain.useCases.GetPagedFoodsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPagedFoodsUseCase: GetPagedFoodsUseCase

) : ViewModel() {

    private val _food = MutableStateFlow<Resource<Food>>(Resource.Idle)

    val food : StateFlow<Resource<Food>> = _food.asStateFlow()

    private val _pagingData = MutableStateFlow<PagingData<Recipe>>(PagingData.empty())
    val pagingData: StateFlow<PagingData<Recipe>> = _pagingData


    fun searchFood(query: String) {
        val standardizedQuery = query.trim().lowercase()
        viewModelScope.launch {
            getPagedFoodsUseCase(standardizedQuery)
                .cachedIn(viewModelScope)
                .collectLatest { data ->
                    _pagingData.value = data
                }
        }
    }
}



