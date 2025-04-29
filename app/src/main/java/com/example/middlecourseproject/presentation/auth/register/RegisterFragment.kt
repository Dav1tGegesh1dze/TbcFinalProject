package com.example.middlecourseproject.presentation.auth.register

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentRegisterBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun start() {
        setupListeners()
        observeState()
        observeSideEffects()
        togglePasswordVisibility()
    }

    private fun setupListeners() {
        binding.emailInputRegister.addTextChangedListener { text ->
            registerViewModel.processIntent(RegisterIntent.EnterEmail(text.toString()))
        }

        binding.passwordInputRegister.addTextChangedListener { text ->
            registerViewModel.processIntent(RegisterIntent.EnterPassword(text.toString()))
        }
        binding.registerButton.setOnClickListener {
            registerViewModel.processIntent(RegisterIntent.ClickRegister)
        }
        binding.toLoginPage.setOnClickListener {
            registerViewModel.processIntent(RegisterIntent.ClickLogin)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                registerViewModel.state.collect { state ->
                    binding.emailInputRegister.error = state.emailError
                    binding.passwordInputRegister.error = state.passwordError

                    if (state.isLoading) {
                        binding.registerButton.isEnabled = false
                        binding.registerButton.text = ""
                        binding.registerButtonLoader.visibility = View.VISIBLE
                    } else {
                        binding.registerButton.isEnabled = true
                        binding.registerButtonLoader.visibility = View.GONE
                        binding.registerButton.setText(R.string.register)
                    }
                }
            }
        }
    }

    private fun observeSideEffects() {
        viewLifecycleOwner.lifecycleScope.launch {
            registerViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is RegisterSideEffect.ShowSnackbar -> binding.root.showSnackbar(effect.message)
                    is RegisterSideEffect.NavigateToOtpValidation -> {
                    }
                    is RegisterSideEffect.NavigateToLogin -> {
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    private fun togglePasswordVisibility() {
        binding.passwordToggleRegister.setOnClickListener {
            val isPasswordVisible = binding.passwordInputRegister.inputType and
                    android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD ==
                    android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

            binding.passwordInputRegister.inputType =
                if (isPasswordVisible)
                    android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
                else
                    android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

            binding.passwordInputRegister.setSelection(binding.passwordInputRegister.text?.length ?: 0)
        }
    }
}