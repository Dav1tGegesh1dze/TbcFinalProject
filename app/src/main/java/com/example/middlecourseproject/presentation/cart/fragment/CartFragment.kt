package com.example.middlecourseproject.presentation.cart.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentCartBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.cart.adapter.CartAdapter
import com.example.middlecourseproject.presentation.cart.viewmodel.CartViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(
    FragmentCartBinding::inflate
) {
    private val viewModel: CartViewModel by viewModels()
    private lateinit var cartAdapter: CartAdapter

    override fun start() {
        setupRecyclerView()
        setupListeners()
        observeState()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initially show loading
        binding.progressBar.visibility = View.VISIBLE
        binding.groupEmptyCart.visibility = View.GONE
        binding.groupCartContent.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(
            onIncreaseQuantity = { dishId ->
                viewModel.increaseQuantity(dishId)
            },
            onDecreaseQuantity = { dishId ->
                viewModel.decreaseQuantity(dishId)
            },
            onRemoveItem = { dishId ->
                viewModel.removeItem(dishId)
            }
        )

        binding.rvCartItems.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(requireContext())
            // Set initial items to an empty list to prevent null references
            cartAdapter.submitList(emptyList())
        }
    }

    private fun setupListeners() {
        binding.btnCheckout.setOnClickListener {
            // Safety check
            if (!isAdded()) return@setOnClickListener

            // Check if cart is empty
            if (viewModel.state.value.cartItems.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Your cart is empty. Add some items before checkout.",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // Navigate to checkout
            try {
                findNavController().navigate(R.id.action_cartFragment_to_checkoutFragment)
            } catch (e: Exception) {
                Log.e("CartFragment", "Error during navigation: ${e.message}", e)
                if (isAdded()) {
                    Snackbar.make(
                        binding.root,
                        "Navigation error: ${e.message}",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    if (!isAdded()) return@collectLatest

                    try {
                        // Update UI
                        binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                        // Create a new list to avoid modifying the existing one
                        val newList = state.cartItems.toList()
                        cartAdapter.submitList(newList)

                        // Format price
                        val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                        binding.tvTotalPrice.text = formatter.format(state.cartTotal)

                        // Update visibility based on cart status
                        val isEmpty = state.cartItems.isEmpty()
                        binding.groupEmptyCart.visibility = if (isEmpty) View.VISIBLE else View.GONE
                        binding.groupCartContent.visibility = if (isEmpty) View.GONE else View.VISIBLE

                        // Handle errors
                        state.error?.let { error ->
                            if (isAdded()) {
                                Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
                            }
                        }
                    } catch (e: Exception) {
                        Log.e("CartFragment", "Error updating UI: ${e.message}", e)
                        if (isAdded()) {
                            Snackbar.make(binding.root, "UI update error: ${e.message}", Snackbar.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        try {
            // Clean up references
            binding.rvCartItems.adapter = null
        } catch (e: Exception) {
            Log.e("CartFragment", "Error during cleanup: ${e.message}", e)
        }
        super.onDestroyView()
    }
}