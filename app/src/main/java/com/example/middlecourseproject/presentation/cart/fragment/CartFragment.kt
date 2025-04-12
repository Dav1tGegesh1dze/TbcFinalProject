package com.example.middlecourseproject.presentation.cart.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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
        }
    }

    private fun setupListeners() {
        binding.btnCheckout.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Order placed successfully!",
                Snackbar.LENGTH_LONG
            ).show()
            viewModel.clearCart()
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                // update
                cartAdapter.submitList(state.cartItems)

                // proicee
                val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                binding.tvTotalPrice.text = formatter.format(state.cartTotal)

                val isEmpty = state.cartItems.isEmpty()
                binding.groupEmptyCart.visibility = if (isEmpty) View.VISIBLE else View.GONE
                binding.groupCartContent.visibility = if (isEmpty) View.GONE else View.VISIBLE

                // errors
                state.error?.let { error ->
                    Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}