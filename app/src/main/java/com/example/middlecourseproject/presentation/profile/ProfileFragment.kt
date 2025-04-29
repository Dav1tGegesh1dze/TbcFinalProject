package com.example.middlecourseproject.presentation.profile

import android.app.AlertDialog
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentProfileBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun start() {
        setupListeners()
        observeState()
        observeSideEffects()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("ProfileFragment", "Configuration changed: ${newConfig.uiMode}")
    }

    private fun setupListeners() {
        binding.signOutButton.setOnClickListener {
            showSignOutConfirmationDialog()
        }

        binding.themeToggle.setOnCheckedChangeListener { _, isChecked ->
            Log.d("ProfileFragment", "Theme toggle changed to: $isChecked")
            if (isChecked != profileViewModel.state.value.isDarkMode) {
                profileViewModel.processIntent(ProfileIntent.ToggleTheme)
                findNavController().navigate(R.id.action_profileFragment_to_restaurantFragment)
            }
        }

        binding.languageToggleButton.setOnClickListener {
            profileViewModel.processIntent(ProfileIntent.ToggleLanguage)
        }

        binding.ordersContainer.setOnClickListener {
            // LAter to do with this functionalitu
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.state.collect { state ->
                    Log.d("ProfileFragment", "State update - isDarkMode: ${state.isDarkMode}")
                    binding.themeToggle.isChecked = state.isDarkMode
                    updateLanguageButton(state.currentLanguage)
                }
            }
        }
    }

    private fun observeSideEffects() {
        viewLifecycleOwner.lifecycleScope.launch {
            profileViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is ProfileSideEffect.NavigateToLogin -> navigateToLogin()
                    is ProfileSideEffect.ShowSnackbar -> {
                        binding.root.showSnackbar(effect.message)
                        Log.d("ProfileFragment", "Showing snackbar: ${effect.message}")
                    }
                    is ProfileSideEffect.LanguageToggled -> {
                        Log.d("ProfileFragment", "Language toggled to: ${effect.language}")
                        requireActivity().recreate()
                    }
                }
            }
        }
    }

    private fun navigateToLogin() {
        findNavController().navigate(
            R.id.loginFragment,
            null,
            androidx.navigation.NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .build()
        )
    }

    private fun showSignOutConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.sign_out)
            .setMessage(R.string.sign_out_confirmation)
            .setPositiveButton(R.string.yes) { _, _ ->
                profileViewModel.processIntent(ProfileIntent.SignOut)
            }
            .setNegativeButton(R.string.no, null)
            .show()
    }

    private fun updateLanguageButton(currentLang: String) {
        val buttonText = if (currentLang == "en") "ქარ" else "ENG"
        binding.languageToggleButton.text = buttonText
    }
}