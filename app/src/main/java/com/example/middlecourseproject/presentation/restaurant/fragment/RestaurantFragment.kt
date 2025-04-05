package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.middlecourseproject.databinding.FragmentRestaurantBinding
import com.example.middlecourseproject.presentation.restaurant.event.RestaurantEvent
import com.example.middlecourseproject.presentation.restaurant.viewmodel.RestaurantViewModel
import com.example.middlecourseproject.presentation.restaurant.adapter.CategoryAdapter
import com.example.middlecourseproject.presentation.restaurant.adapter.RestaurantAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by viewModels()

    private val categoryAdapter = CategoryAdapter { categoryId ->
        viewModel.onEvent(RestaurantEvent.CategorySelected(categoryId))
    }

    private val restaurantAdapter = RestaurantAdapter { restaurantId ->
        viewModel.onEvent(RestaurantEvent.RestaurantSelected(restaurantId))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        observeState()

        // Data
        viewModel.onEvent(RestaurantEvent.LoadCategories)
        viewModel.onEvent(RestaurantEvent.LoadAllRestaurants)
    }

    private fun setupRecyclerViews() {
        binding.rvCategories.adapter = categoryAdapter
        binding.rvRestaurants.adapter = restaurantAdapter
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                // progress bar
                binding.progressBar.isVisible = state.isLoading
                categoryAdapter.submitList(state.categories)
                categoryAdapter.setSelectedCategory(state.selectedCategoryId)
                restaurantAdapter.submitList(state.restaurants)
                state.error?.let {
                    //Error messages
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}