// RegisterFragment.kt
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

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun start() {
        observeLoading()
        observeRegisterEvents()
        onRegister()
        togglePasswordVisibility()
        toLogin()
    }

    private fun onRegister() {
        binding.registerButton.setOnClickListener {
            val email = binding.emailInputRegister.text.toString()
            val password = binding.passwordInputRegister.text.toString()
            val userName = binding.userNameInput.text.toString()
            when {
                email.isEmpty() || password.isEmpty() || userName.isEmpty() -> {
                    binding.root.showSnackbar(getString(R.string.fill_all_fields))
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.root.showSnackbar(getString(R.string.valid_email))
                }
                else -> {
                    registerViewModel.register(email, userName, password)
                }
            }
        }
    }

    private fun observeLoading() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                registerViewModel.loading.collect { isLoading ->
                    if (isLoading) {
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

    private fun observeRegisterEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            registerViewModel.registerEvent.collect { event ->
                when (event) {
                    is RegisterEvent.Success -> {
                        val email = binding.emailInputRegister.text.toString()
                        val userName = binding.userNameInput.text.toString()
                        val password = binding.passwordInputRegister.text.toString()

                        // Optionally clear backstack and navigate to OTP validation screen
                        val navOptions = NavOptions.Builder()
                            .setPopUpTo(R.id.loginFragment, true)
                            .build()
                        findNavController().navigate(
                            RegisterFragmentDirections.actionRegisterFragmentToOtpValidation(email,userName,password),
                            navOptions
                        )
                    }
                    is RegisterEvent.Error -> {
                        binding.root.showSnackbar(event.message)
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

    private fun toLogin() {
        binding.toLoginPage.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
