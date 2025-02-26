// LoginFragment.kt
package com.example.middlecourseproject.presentation.auth.logIn

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R

import com.example.middlecourseproject.databinding.FragmentLoginBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel: LoginViewModel by viewModels()


    override fun start() {
        loginViewModel.loadLanguage()
        observeLoginState()
        onLogin()
        togglePasswordVisibility()
        navigateToRegister()
        setupLanguageToggleButton()
        observeLanguageState()
        observeLanguageToggle()
    }

    private fun onLogin() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailInputLogin.text.toString()
            val password = binding.passwordInputLogin.text.toString()
            when {
                email.isEmpty() || password.isEmpty() -> {
                    Snackbar.make(binding.root, "Fill all fields", Snackbar.LENGTH_LONG).show()
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Snackbar.make(binding.root, "Input a valid email address", Snackbar.LENGTH_LONG).show()
                }
                else -> {
                    loginViewModel.login(email, password)
                }
            }
        }
    }

    private fun observeLoginState() {
        // Observe persistent loading state.
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.loading.collect { isLoading ->
                    if (isLoading) {
                        binding.loginButton.isEnabled = false
                        binding.loginButton.text = ""
                        binding.loginButtonLoader.visibility = View.VISIBLE
                    } else {
                        binding.loginButton.isEnabled = true
                        binding.loginButtonLoader.visibility = View.GONE
                        binding.loginButton.setText(R.string.log_in)
                    }
                }
            }
        }
        // Observe one-time login events.
        viewLifecycleOwner.lifecycleScope.launch {
            loginViewModel.loginEvent.collect { event ->
                when (event) {
                    is LoginEvent.Success -> navigateToHome()
                    is LoginEvent.Error -> Snackbar.make(binding.root, event.message, Snackbar.LENGTH_LONG).show()
                    else -> {}
                }
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHome2())
    }

    private fun togglePasswordVisibility() {
        binding.passwordToggleLogin.setOnClickListener {
            val isPasswordVisible = binding.passwordInputLogin.inputType and
                    android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

            binding.passwordInputLogin.inputType = if (isPasswordVisible) {
                android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            binding.passwordInputLogin.setSelection(binding.passwordInputLogin.text?.length ?: 0)
        }
    }



    private fun navigateToRegister() {
        binding.toRegisterPage.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    private fun observeLanguageState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.language.collect { currentLang ->
                    // Here, instead of showing the current language,
                    // show the alternative language as the button label.
                    updateLanguageButton(currentLang)
                }
            }
        }
    }

    // Listen for one-time language toggle events.
    private fun observeLanguageToggle() {
        viewLifecycleOwner.lifecycleScope.launch {
            loginViewModel.languageToggleEvent.collect {
                requireActivity().recreate()
            }
        }
    }

    // Set up the language toggle button.
    private fun setupLanguageToggleButton() {
        binding.langToggleButton.setOnClickListener {
            loginViewModel.toggleLanguage()
        }
    }

    // Update the language button UI so it displays the alternative language.
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