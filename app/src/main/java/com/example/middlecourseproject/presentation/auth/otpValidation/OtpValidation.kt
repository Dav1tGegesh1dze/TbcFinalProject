package com.example.middlecourseproject.presentation.auth.otpValidation

import android.view.KeyEvent
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentOtpValidationBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OtpValidationFragment : BaseFragment<FragmentOtpValidationBinding>(FragmentOtpValidationBinding::inflate) {

    private val otpViewModel: OtpValidationViewModel by viewModels()
    private val args: OtpValidationFragmentArgs by navArgs()

    override fun start() {
        otpViewModel.setCredentials(args.email, args.userName, args.password)
        setupOtpInputs()
        setupResendButton()
        observeState()
        observeSideEffects()
    }

    private fun setupOtpInputs() {
        binding.otpDigit1.doAfterTextChanged { text ->
            if (text?.length == 1) binding.otpDigit2.requestFocus()
        }
        binding.otpDigit2.doAfterTextChanged { text ->
            if (text?.length == 1) binding.otpDigit3.requestFocus()
        }
        binding.otpDigit3.doAfterTextChanged { text ->
            if (text?.length == 1) binding.otpDigit4.requestFocus()
        }
        binding.otpDigit4.doAfterTextChanged { text ->
            if (text?.length == 1) {
                val otp = binding.otpDigit1.text.toString() +
                        binding.otpDigit2.text.toString() +
                        binding.otpDigit3.text.toString() +
                        binding.otpDigit4.text.toString()
                otpViewModel.processIntent(OtpValidationIntent.SubmitOtp(otp))
            }
        }

        binding.otpDigit2.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.otpDigit2.text.isNullOrEmpty()) {
                    binding.otpDigit1.requestFocus()
                    binding.otpDigit1.text?.clear()
                    return@setOnKeyListener true
                }
            }
            false
        }

        binding.otpDigit3.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.otpDigit3.text.isNullOrEmpty()) {
                    binding.otpDigit2.requestFocus()
                    binding.otpDigit2.text?.clear()
                    return@setOnKeyListener true
                }
            }
            false
        }

        binding.otpDigit4.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                if (binding.otpDigit4.text.isNullOrEmpty()) {
                    binding.otpDigit3.requestFocus()
                    binding.otpDigit3.text?.clear()
                    return@setOnKeyListener true
                }
            }
            false
        }
    }

    private fun setupResendButton() {
        binding.resendButton.setOnClickListener {
            otpViewModel.processIntent(OtpValidationIntent.ResendOtp)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            otpViewModel.state.collect { state ->
                val minutes = state.timerSeconds / 60
                val secs = state.timerSeconds % 60
                binding.timerTextView.text = String.format("%02d:%02d", minutes, secs)

                if (state.isResending) {
                    binding.resendButton.isEnabled = false
                    binding.otpButtonLoader.visibility = View.VISIBLE
                    binding.resendButton.text = ""
                } else {
                    binding.resendButton.isEnabled = true
                    binding.otpButtonLoader.visibility = View.GONE
                    binding.resendButton.setText(R.string.resend_otp)
                }
            }
        }
    }

    private fun observeSideEffects() {
        viewLifecycleOwner.lifecycleScope.launch {
            otpViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is OtpValidationSideEffect.ShowValidationError -> {
                        binding.root.showSnackbar(effect.message)
                        clearOtpInputs()
                    }
                    is OtpValidationSideEffect.ShowResendSuccess -> {
                        binding.root.showSnackbar(getString(R.string.otp_resend_successfully))
                    }
                    is OtpValidationSideEffect.ShowResendError -> {
                        binding.root.showSnackbar(effect.message)
                    }
                    is OtpValidationSideEffect.NavigateToDetails -> {
                        findNavController().navigate(
                            OtpValidationFragmentDirections.actionOtpValidationToDetailsFragment()
                        )
                    }
                }
            }
        }
    }

    private fun clearOtpInputs() {
        binding.otpDigit1.text?.clear()
        binding.otpDigit2.text?.clear()
        binding.otpDigit3.text?.clear()
        binding.otpDigit4.text?.clear()
        binding.otpDigit1.requestFocus()
    }
}