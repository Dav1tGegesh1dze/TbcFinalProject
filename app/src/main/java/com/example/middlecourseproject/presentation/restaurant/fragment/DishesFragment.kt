package com.example.middlecourseproject.presentation.restaurant.fragment


import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentDishesBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.restaurant.adapter.DishAdapter
import com.example.middlecourseproject.presentation.restaurant.viewmodel.DishesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DishesFragment : BaseFragment<FragmentDishesBinding>(
    FragmentDishesBinding::inflate
) {
    private val viewModel: DishesViewModel by viewModels()
    private val args: DishesFragmentArgs by navArgs()

    private val dishAdapter = DishAdapter { dishId ->
        // Handle add click after for card or something like that
    }

    override fun start() {
        setupRecyclerView()
        viewModel.loadRestaurantDetails(args.restaurantId)
        observeState()
    }

    private fun setupRecyclerView() {
        binding.rvDishes.apply {
            adapter = dishAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                // Details
                state.restaurant?.let { restaurant ->
                    binding.tvRestaurantName.text = restaurant.name
                    binding.tvRestaurantDescription.text = restaurant.fullDescription
                    binding.ratingBar.rating = restaurant.rating.toFloat()
                    binding.tvRating.text = restaurant.rating.toString()

                    binding.tvLocation.text = restaurant.location.address

                    Glide.with(requireContext())
                        .load(restaurant.mainImage)
                        .centerCrop()
                        //placholders
                        .placeholder(R.drawable.ic_launcher_foreground)
                        //error
                        .error(R.drawable.ic_launcher_foreground)
                        .into(binding.ivRestaurantImage)

                    // menu from cateories
                    val allDishes = restaurant.menu.flatMap { it.dishes }
                    dishAdapter.submitList(allDishes)
                }

                state.error?.let { error ->
                    // Show error message
                }
            }
        }
    }
}