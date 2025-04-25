package com.example.middlecourseproject.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.restaurant.model.Restaurant
import com.example.middlecourseproject.domain.restaurant.usecase.GetCategoriesUseCase
import com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase
import com.example.middlecourseproject.domain.search.usecase.SearchUseCase
import com.example.middlecourseproject.presentation.search.event.SearchEvent
import com.example.middlecourseproject.presentation.search.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getRestaurantsByCategoryUseCase: GetRestaurantsByCategoryUseCase,
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.LoadPopularSearches -> {
                loadPopularSearches()
            }
            is SearchEvent.LoadAllRestaurants -> {
                loadAllRestaurants()
            }
            is SearchEvent.Search -> {
                search(event.query)
            }
            is SearchEvent.RestaurantSelected -> {
                // Future functionality - could track selected restaurants
            }
            is SearchEvent.ClearSearch -> {
                clearSearch()
            }
            is SearchEvent.ErrorShown -> {
                _state.value = _state.value.copy(error = null)
            }
        }
    }

    private fun loadPopularSearches() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            // Get popular search terms from search use case
            searchUseCase.getPopularSearchTerms()
                .onEach { searchTerms ->
                    _state.value = _state.value.copy(
                        popularSearches = searchTerms,
                        isLoading = false
                    )
                }
                .catch { error ->
                    _state.value = _state.value.copy(
                        error = error.message,
                        isLoading = false
                    )
                }
                .launchIn(this)
        }
    }

    private fun loadAllRestaurants() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            getRestaurantsByCategoryUseCase(null)
                .onEach { restaurants ->
                    _state.value = _state.value.copy(
                        allRestaurants = restaurants,
                        isLoading = false
                    )

                    // If there's an active search, update the results
                    if (_state.value.searchQuery.isNotEmpty()) {
                        search(_state.value.searchQuery)
                    }
                }
                .catch { error ->
                    _state.value = _state.value.copy(
                        error = error.message,
                        isLoading = false
                    )
                }
                .launchIn(this)
        }
    }

    private fun search(query: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                searchQuery = query,
                isLoading = true
            )

            if (query.isEmpty()) {
                _state.value = _state.value.copy(
                    searchResults = emptyList(),
                    isLoading = false
                )
                return@launch
            }

            // Use search use case to get results
            searchUseCase.searchRestaurants(query)
                .onEach { results ->
                    _state.value = _state.value.copy(
                        searchResults = results,
                        isLoading = false
                    )
                }
                .catch { error ->
                    _state.value = _state.value.copy(
                        error = error.message,
                        isLoading = false
                    )
                }
                .launchIn(this)
        }
    }

    private fun clearSearch() {
        _state.value = _state.value.copy(
            searchQuery = "",
            searchResults = emptyList()
        )
    }
}