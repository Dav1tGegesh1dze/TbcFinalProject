package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentDishesBinding
import com.example.middlecourseproject.presentation.restaurant.adapter.DishAdapter
import com.example.middlecourseproject.presentation.restaurant.viewmodel.DishesViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DishesFragment : Fragment() {

    private var _binding: FragmentDishesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DishesViewModel by viewModels()
    private val args: DishesFragmentArgs by navArgs()

    private val dishAdapter = DishAdapter { dishId ->
        // Handle add click after for card or something like that
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.loadRestaurantDetails(args.restaurantId)

        observeState()
    }

    private fun setupRecyclerView() {
        binding.rvDishes.apply {
            adapter = dishAdapter
            layoutManager = GridLayoutManager(requireContext(), 2) // 2 columns
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

                    // Flatten all dishes from all menu categories
                    val allDishes = restaurant.menu.flatMap { it.dishes }
                    dishAdapter.submitList(allDishes)
                }


                state.error?.let { error ->
                    // Show error message
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}