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
import com.example.middlecourseproject.utils.showSnackbar
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
                    binding.root.showSnackbar(getString(R.string.fill_all_fields))
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.root.showSnackbar(getString(R.string.valid_email))
                }
                else -> {
                    loginViewModel.login(email, password)
                }
            }
        }
    }

    private fun observeLoginState() {
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
        viewLifecycleOwner.lifecycleScope.launch {
            loginViewModel.loginEvent.collect { event ->
                when (event) {
                    is LoginEvent.Success -> navigateToHome()
                    is LoginEvent.Error ->
                        binding.root.showSnackbar(event.message)
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

                    updateLanguageButton(currentLang)
                }
            }
        }
    }

    private fun observeLanguageToggle() {
        viewLifecycleOwner.lifecycleScope.launch {
            loginViewModel.languageToggleEvent.collect {
                requireActivity().recreate()
            }
        }
    }

    private fun setupLanguageToggleButton() {
        binding.langToggleButton.setOnClickListener {
            loginViewModel.toggleLanguage()
        }
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