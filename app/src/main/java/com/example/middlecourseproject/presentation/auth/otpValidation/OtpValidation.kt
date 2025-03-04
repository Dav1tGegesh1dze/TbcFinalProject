package com.example.middlecourseproject.presentation.auth.otpValidation

import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentOtpValidationBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OtpValidationFragment : BaseFragment<FragmentOtpValidationBinding>(FragmentOtpValidationBinding::inflate) {

    private val otpViewModel: OtpValidationViewModel by viewModels()

    private val args: OtpValidationFragmentArgs by navArgs()

    override fun start() {
        setupOtpInputs()
        observeTimer()
        observeOtpSuccessEvent()
        observeOtpErrorEvent()
        observeResendEvent()
        setupResendButton()

    }

    private fun setupResendButton() {
        binding.resendButton.setOnClickListener {
            otpViewModel.resendOtp(args.email, args.userName, args.password)
        }
    }

    private fun observeResendEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                otpViewModel.resendEvent.collect { state ->
                    when (state) {
                        is Resource.Idle ->{
                            binding.resendButton.isEnabled = true
                            binding.otpButtonLoader.visibility = View.GONE
                            binding.resendButton.setText(R.string.resend_otp)
                        }
                        is Resource.Loading -> {
                            binding.resendButton.isEnabled = false
                            binding.otpButtonLoader.visibility = View.VISIBLE
                            binding.resendButton.text = ""
                        }
                        is Resource.Success -> {
                            binding.resendButton.isEnabled = true
                            binding.otpButtonLoader.visibility = View.GONE
                            binding.resendButton.setText(R.string.resend_otp)
                            binding.root.showSnackbar(getString(R.string.otp_resend_successfully))
                        }
                        is Resource.Error -> {
                            binding.resendButton.isEnabled = true
                            binding.otpButtonLoader.visibility = View.GONE
                            binding.resendButton.setText(R.string.resend_otp)
                            binding.root.showSnackbar(state.message)
                        }
                    }
                }
            }
        }
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
                otpViewModel.validateOtp(otp, args.email, args.password)
            }
        }
    }

    private fun observeTimer() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                otpViewModel.timerSeconds.collect { seconds ->
                    val minutes = seconds / 60
                    val secs = seconds % 60
                    binding.timerTextView.text = String.format("%02d:%02d", minutes, secs)
                }
            }
        }
    }

    private fun observeOtpSuccessEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            otpViewModel.otpSuccessEvent.collect {
                findNavController().navigate(
                    OtpValidationFragmentDirections.actionOtpValidationToDetailsFragment()
                )
            }
        }
    }

    private fun observeOtpErrorEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                otpViewModel.otpErrorEvent.collect { errorMessage ->
                    binding.root.showSnackbar(errorMessage)

                    clearOtpInputs()
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
