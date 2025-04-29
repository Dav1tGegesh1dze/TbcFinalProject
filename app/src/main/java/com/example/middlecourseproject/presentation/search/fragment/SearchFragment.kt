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

        try {
            val currentDestId = findNavController().currentDestination?.id


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

        viewModel.onEvent(SearchEvent.LoadPopularSearches)
        viewModel.onEvent(SearchEvent.LoadAllRestaurants)
    }

    private fun setupRecyclerViews() {
        binding.rvSearchCategories.apply {
            adapter = searchCategoryAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        binding.rvSearchResults.apply {
            adapter = restaurantAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun setupSearch() {
        binding.btnClearSearch.setOnClickListener {
            binding.etSearch.text?.clear()
            viewModel.onEvent(SearchEvent.ClearSearch)
        }

        binding.ivBackButton.setOnClickListener {
            try {
                findNavController().navigateUp()
            } catch (e: Exception) {
                findNavController().navigate(R.id.restaurantFragment)
            }
        }

        binding.etSearch.addTextChangedListener { editable ->
            binding.btnClearSearch.isVisible = !editable.isNullOrEmpty()

            viewLifecycleOwner.lifecycleScope.launch {
                delay(300)
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
                binding.progressBar.isVisible = state.isLoading

                searchCategoryAdapter.submitList(state.popularSearches)
                restaurantAdapter.submitList(state.searchResults)

                binding.tvNoResults.isVisible = state.searchResults.isEmpty() &&
                        !state.isLoading &&
                        state.searchQuery.isNotEmpty()

                binding.rvSearchCategories.isVisible = state.searchQuery.isEmpty()
                binding.tvPopularSearches.isVisible = state.searchQuery.isEmpty()

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