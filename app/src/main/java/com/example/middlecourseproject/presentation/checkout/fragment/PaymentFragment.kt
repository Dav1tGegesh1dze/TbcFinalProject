package com.example.middlecourseproject.presentation.checkout.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.databinding.FragmentPaymentBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentFragment : BaseFragment<FragmentPaymentBinding>(
    FragmentPaymentBinding::inflate
) {
    private val viewModel: PaymentViewModel by viewModels()

    override fun start() {
        setupListeners()
        setupTextFormatting()
        observeState()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnAddCard.setOnClickListener {
            val cardNumber = binding.etCardNumber.text.toString().replace(" ", "").trim()
            val expiryDate = binding.etExpiryDate.text.toString().trim()
            val cvv = binding.etCvv.text.toString().trim()
            val cardholderName = binding.etCardholderName.text.toString().trim()

            viewModel.addCard(cardNumber, expiryDate, cvv, cardholderName)
        }
    }

    private fun setupTextFormatting() {
        binding.etCardNumber.addTextChangedListener(object : TextWatcher {
            private var isFormatting = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isFormatting) return

                isFormatting = true

                val text = s.toString().replace(" ", "")
                val formatted = StringBuilder()

                for (i in text.indices) {
                    if (i > 0 && i % 4 == 0) {
                        formatted.append(" ")
                    }
                    formatted.append(text[i])
                }

                if (formatted.toString() != s.toString()) {
                    s?.replace(0, s.length, formatted)
                }

                isFormatting = false
            }
        })

        binding.etExpiryDate.addTextChangedListener(object : TextWatcher {
            private var isFormatting = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isFormatting) return

                isFormatting = true

                val text = s.toString().replace("/", "")
                val formatted = StringBuilder()

                for (i in text.indices) {
                    if (i == 2 && i < text.length) {
                        formatted.append("/")
                    }
                    if (i < text.length) {
                        formatted.append(text[i])
                    }
                }

                if (formatted.toString() != s.toString()) {
                    s?.replace(0, s.length, formatted)
                }

                isFormatting = false
            }
        })
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                binding.tilCardNumber.error = state.cardNumberError
                binding.tilExpiryDate.error = state.expiryDateError
                binding.tilCvv.error = state.cvvError
                binding.tilCardholderName.error = state.cardholderNameError

                if (state.cardAdded) {
                    Snackbar.make(
                        binding.root,
                        "Payment method added successfully",
                        Snackbar.LENGTH_LONG
                    ).show()
                    findNavController().navigateUp()
                }

                // Handle error
                state.error?.let { error ->
                    Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}