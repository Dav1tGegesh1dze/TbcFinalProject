package com.example.middlecourseproject.presentation.checkout.fragment

import android.app.AlertDialog
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentCheckoutBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CheckoutFragment : BaseFragment<FragmentCheckoutBinding>(
    FragmentCheckoutBinding::inflate
) {
    private val viewModel: CheckoutViewModel by viewModels()

    override fun start() {
        setupListeners()
        observeState()
        viewModel.loadCartSummary()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.layoutPaymentMethod.setOnClickListener {
            findNavController().navigate(
                CheckoutFragmentDirections.actionCheckoutFragmentToPaymentFragment()
            )
        }

        binding.layoutRedeemCode.setOnClickListener {
            showPromoCodeDialog()
        }

        binding.layoutDeliveryAddress.setOnClickListener {
            showAddressUpdateDialog()
        }

        // Tips
        binding.chipTip0.setOnClickListener { viewModel.setTip(0.0) }
        binding.chipTip1.setOnClickListener { viewModel.setTip(1.0) }
        binding.chipTip3.setOnClickListener { viewModel.setTip(3.0) }
        binding.chipTip5.setOnClickListener { viewModel.setTip(5.0) }

        binding.chipTipCustom.setOnClickListener {
            showCustomTipDialog()
        }

        binding.btnPlaceOrder.setOnClickListener {
            viewModel.placeOrder()
        }
    }

    private fun showPromoCodeDialog() {
        val inputEditText = EditText(requireContext()).apply {
            hint = "Enter promo code"
            inputType = InputType.TYPE_CLASS_TEXT
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Redeem Code")
        builder.setView(inputEditText)
        builder.setPositiveButton("Apply") { dialog, _ ->
            val code = inputEditText.text.toString().trim()
            if (code.isNotEmpty()) {
                viewModel.applyPromoCode(code)
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun showAddressUpdateDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Update Delivery Address")

        val layout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 16, 32, 16)
        }

        val addressInput = EditText(requireContext()).apply {
            hint = "Address"
            setText(viewModel.state.value.deliveryAddress.coordinates)
        }

        val detailsInput = EditText(requireContext()).apply {
            hint = "Details (entrance, floor, etc.)"
            setText(viewModel.state.value.deliveryAddress.details)
        }

        layout.addView(addressInput)
        layout.addView(detailsInput)

        builder.setView(layout)

        builder.setPositiveButton("Update") { _, _ ->
            val coordinates = addressInput.text.toString()
            val details = detailsInput.text.toString()

            if (coordinates.isNotEmpty()) {
                viewModel.updateDeliveryAddress(coordinates, details)
            }
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showCustomTipDialog() {
        val inputEditText = EditText(requireContext()).apply {
            hint = "Enter tip amount"
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Custom Tip")
        builder.setView(inputEditText)
        builder.setPositiveButton("Set") { dialog, _ ->
            val tipText = inputEditText.text.toString().trim()
            if (tipText.isNotEmpty()) {
                try {
                    val tipAmount = tipText.toDouble()
                    viewModel.setTip(tipAmount)
                } catch (e: NumberFormatException) {
                    Snackbar.make(binding.root, "Please enter a valid amount", Snackbar.LENGTH_SHORT).show()
                }
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                binding.tvSubtotal.text = "${state.subtotal} ₾"
                binding.tvBagFee.text = "${state.bagFee} ₾"
                binding.tvSmallOrderFee.text = "${state.smallOrderFee} ₾"
                binding.tvServiceFee.text = "${state.serviceFee} ₾"
                binding.tvDeliveryFee.text = "${state.deliveryFee} ₾"
                binding.tvTotal.text = "${state.total} ₾"

                // promo code
                if (state.promoCode != null) {
                    binding.tvCodeDescription.text = "Code applied: ${state.promoCode}"

                    if (binding.root.findViewById<TextView>(R.id.tvDiscount) == null) {
                        addDiscountRow(state.discount)
                    } else {
                        binding.root.findViewById<TextView>(R.id.tvDiscount).text = "-${state.discount} ₾"
                    }
                }

                binding.tvAddressCoordinates.text = state.deliveryAddress.coordinates
                binding.tvAddressDetails.text = state.deliveryAddress.details

                if (state.paymentMethod != null) {
                    binding.tvPaymentMethod.text = "•••• ${state.paymentMethod.lastFour}"
                    binding.tvPaymentAmount.text = "Will be charged for ${state.total} ₾"
                } else {
                    binding.tvPaymentMethod.text = "Add payment method"
                    binding.tvPaymentAmount.text = ""
                }

                binding.btnPlaceOrder.isEnabled = state.paymentMethod != null
                binding.btnPlaceOrder.text = "Place Order"

                state.error?.let { error ->
                    Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
                }

                if (state.orderPlaced) {
                    Snackbar.make(binding.root, "Order placed successfully!", Snackbar.LENGTH_LONG).show()
                    findNavController().navigate(
                        CheckoutFragmentDirections.actionCheckoutFragmentToOrderConfirmationFragment()
                    )
                }
            }
        }
    }

    private fun addDiscountRow(discount: Double) {
        val discountLabel = TextView(requireContext()).apply {
            id = View.generateViewId()
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            text = "Discount"
            setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
        }

        val discountValue = TextView(requireContext()).apply {
            id = R.id.tvDiscount
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            text = "-${discount} ₾"
            setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
        }

        val parentLayout = binding.tvTotalLabel.parent as ViewGroup

        val totalIndex = parentLayout.indexOfChild(binding.tvTotalLabel)
        parentLayout.addView(discountLabel, totalIndex)
        parentLayout.addView(discountValue, totalIndex + 1)
    }
}