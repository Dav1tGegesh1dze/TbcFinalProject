package com.example.middlecourseproject.presentation.restaurant.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentDishesBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.restaurant.adapter.DishAdapter
import com.example.middlecourseproject.presentation.restaurant.viewmodel.DishesViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DishesFragment : BaseFragment<FragmentDishesBinding>(
    FragmentDishesBinding::inflate
), MenuProvider {
    private val viewModel: DishesViewModel by viewModels()
    private val args: DishesFragmentArgs by navArgs()

    private var cartMenuItem: MenuItem? = null

    override fun start() {
        setupRecyclerView()
        setupMenu()
        viewModel.loadRestaurantDetails(args.restaurantId)
        observeState()
    }

    private fun setupRecyclerView() {
        val dishAdapter = DishAdapter { dish ->
            viewModel.addToCart(dish)
        }

        binding.rvDishes.apply {
            adapter = dishAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun setupMenu() {
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                state.restaurant?.let { restaurant ->
                    binding.tvRestaurantName.text = restaurant.name
                    binding.tvRestaurantDescription.text = restaurant.fullDescription
                    binding.ratingBar.rating = restaurant.rating.toFloat()
                    binding.tvRating.text = restaurant.rating.toString()
                    binding.tvLocation.text = restaurant.location.address

                    Glide.with(requireContext())
                        .load(restaurant.mainImage)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(binding.ivRestaurantImage)


                    val dishes = restaurant.menu.flatMap { it.dishes }
                    (binding.rvDishes.adapter as DishAdapter).submitList(dishes)
                }

                updateCartBadge(state.cartItemCount)

                state.message?.let { message ->
                    Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
                }

                state.error?.let { error ->
                    Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun updateCartBadge(count: Int) {
        cartMenuItem?.let { menuItem ->
            if (count > 0) {
                menuItem.title = "Cart ($count)"
            } else {
                menuItem.title = "Cart"
            }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_dishes, menu)
        cartMenuItem = menu.findItem(R.id.action_cart)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_cart -> {
                findNavController().navigate(
                    R.id.action_dishesFragment_to_cartFragment2
                )
                true
            }
            else -> false
        }
    }
}