package com.example.middlecourseproject.presentation.auth.logIn

import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentLoginBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun start() {
        setupListeners()
        observeState()
        observeSideEffects()
    }

    private fun setupListeners() {
        binding.emailInputLogin.addTextChangedListener { text ->

            loginViewModel.processIntent(LoginIntent.EnterEmail(text.toString()))
        }
        binding.passwordInputLogin.addTextChangedListener { text ->
            loginViewModel.processIntent(LoginIntent.EnterPassword(text.toString()))
        }
        binding.loginButton.setOnClickListener {
            loginViewModel.processIntent(LoginIntent.ClickLogin)
        }
        binding.toRegisterPage.setOnClickListener {
            loginViewModel.processIntent(LoginIntent.ClickRegister)
        }
        binding.langToggleButton.setOnClickListener {
            loginViewModel.processIntent(LoginIntent.ToggleLanguage)
        }
        binding.passwordToggleLogin.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.state.collect { state ->
                    if (state.emailError != null) {
                        binding.emailInputLogin.error = state.emailError
                    } else {
                        binding.emailInputLogin.error = null
                    }
                    if (state.passwordError != null) {
                        binding.passwordInputLogin.error = state.passwordError
                    } else {
                        binding.passwordInputLogin.error = null
                    }
                    if (state.isLoading) {
                        binding.loginButton.isEnabled = false
                        binding.loginButton.text = ""
                        binding.loginButtonLoader.visibility = View.VISIBLE
                    } else {
                        binding.loginButton.isEnabled = true
                        binding.loginButtonLoader.visibility = View.GONE
                        binding.loginButton.setText(R.string.log_in)
                    }
                    updateLanguageButton(state.currentLanguage)
                }
            }
        }
    }

    private fun observeSideEffects() {
        viewLifecycleOwner.lifecycleScope.launch {
            loginViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is LoginSideEffect.ShowSnackbar -> binding.root.showSnackbar(effect.message)
                    is LoginSideEffect.NavigateToHome -> navigateToHome()
                    is LoginSideEffect.NavigateToRegister -> navigateToRegister()
                    is LoginSideEffect.LanguageToggled -> requireActivity().recreate()
                }
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRestaurantFragment())
    }

    private fun navigateToRegister() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

    private fun togglePasswordVisibility() {
        val isPasswordVisible = binding.passwordInputLogin.inputType and
                android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

        binding.passwordInputLogin.inputType = if (isPasswordVisible) {
            android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        } else {
            android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }
        binding.passwordInputLogin.setSelection(binding.passwordInputLogin.text?.length ?: 0)
    }

    private fun updateLanguageButton(currentLang: String) {
        val alternativeLang = if (currentLang == "en") "ka" else "en"
        binding.languageText.text = when (alternativeLang) {
            "en" -> "ENG"
            "ka" -> "GEO"
            else -> "ENG"
        }
        if (alternativeLang == "en") {
            binding.languageImage.setImageResource(R.drawable.united_kingdom)
        } else {
            binding.languageImage.setImageResource(R.drawable.georgia)
        }
    }
}