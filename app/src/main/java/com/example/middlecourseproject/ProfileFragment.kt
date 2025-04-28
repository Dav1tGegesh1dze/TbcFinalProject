package com.example.middlecourseproject

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentProfileBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.presentation.profile.ProfileIntent
import com.example.middlecourseproject.presentation.profile.ProfileSideEffect
import com.example.middlecourseproject.presentation.profile.ProfileViewModel
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun start() {
        setupListeners()
        observeState()
        observeSideEffects()
    }

    private fun setupListeners() {
        binding.signOutButton.setOnClickListener {
            showSignOutConfirmationDialog()
        }

        binding.themeToggle.setOnCheckedChangeListener { _, isChecked ->
            profileViewModel.processIntent(ProfileIntent.ToggleTheme)
        }

        binding.languageToggleButton.setOnClickListener {
            profileViewModel.processIntent(ProfileIntent.ToggleLanguage)
        }

        binding.ordersContainer.setOnClickListener {
            // This is just visual - no functionality required
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.state.collect { state ->
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
                    is ProfileSideEffect.ShowSnackbar -> binding.root.showSnackbar(effect.message)
                    is ProfileSideEffect.LanguageToggled -> requireActivity().recreate()
                }
            }
        }
    }

    private fun navigateToLogin() {
        // Pop everything off the back stack and navigate back to login
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