package com.example.middlecourseproject.presentation.search.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentSearchBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.restaurant.adapter.RestaurantAdapter
import com.example.middlecourseproject.presentation.search.adapter.SearchCategoryAdapter
import com.example.middlecourseproject.presentation.search.event.SearchEvent
import com.example.middlecourseproject.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
) {
    private val viewModel: SearchViewModel by viewModels()

    private val searchCategoryAdapter = SearchCategoryAdapter { searchTerm ->
        binding.etSearch.setText(searchTerm)
        viewModel.onEvent(SearchEvent.Search(searchTerm))
    }

    private val restaurantAdapter = RestaurantAdapter { restaurantId ->
        viewModel.onEvent(SearchEvent.RestaurantSelected(restaurantId))

        // Navigate to dishes fragment with the restaurant ID
        try {
            // Check current destination first to avoid navigation errors
            val currentDestId = findNavController().currentDestination?.id

            // Only navigate if we're not already in the dishes fragment
            if (currentDestId != R.id.dishesFragment) {
                val bundle = Bundle().apply {
                    putString("restaurantId", restaurantId)
                }
                findNavController().navigate(R.id.dishesFragment, bundle)
            }
        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                "Navigation error: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun start() {
        setupRecyclerViews()
        setupSearch()
        observeState()

        // Load initial data
        viewModel.onEvent(SearchEvent.LoadPopularSearches)
        viewModel.onEvent(SearchEvent.LoadAllRestaurants)
    }

    private fun setupRecyclerViews() {
        // Setup categories horizontal recycler view
        binding.rvSearchCategories.apply {
            adapter = searchCategoryAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        // Setup restaurant results recycler view
        binding.rvSearchResults.apply {
            adapter = restaurantAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun setupSearch() {
        // Clear button
        binding.btnClearSearch.setOnClickListener {
            binding.etSearch.text?.clear()
            viewModel.onEvent(SearchEvent.ClearSearch)
        }

        // Back button
        binding.ivBackButton.setOnClickListener {
            try {
                findNavController().navigateUp()
            } catch (e: Exception) {
                // Fallback if navigateUp fails
                findNavController().navigate(R.id.restaurantFragment)
            }
        }

        // Search input
        binding.etSearch.addTextChangedListener { editable ->
            // Update clear button visibility
            binding.btnClearSearch.isVisible = !editable.isNullOrEmpty()

            // Debounce search input
            viewLifecycleOwner.lifecycleScope.launch {
                delay(300) // Debounce delay
                val searchQuery = editable?.toString() ?: ""
                if (searchQuery == binding.etSearch.text.toString()) {
                    viewModel.onEvent(SearchEvent.Search(searchQuery))
                }
            }
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                // Update UI based on state
                binding.progressBar.isVisible = state.isLoading

                // Update adapters
                searchCategoryAdapter.submitList(state.popularSearches)
                restaurantAdapter.submitList(state.searchResults)

                // Show results or no results message
                binding.tvNoResults.isVisible = state.searchResults.isEmpty() &&
                        !state.isLoading &&
                        state.searchQuery.isNotEmpty()

                // Update UI based on search state
                binding.rvSearchCategories.isVisible = state.searchQuery.isEmpty()
                binding.tvPopularSearches.isVisible = state.searchQuery.isEmpty()

                // Handle errors
                state.error?.let { errorMessage ->
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    viewModel.onEvent(SearchEvent.ErrorShown)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Request focus on search input when screen opens
        binding.etSearch.requestFocus()
    }
}