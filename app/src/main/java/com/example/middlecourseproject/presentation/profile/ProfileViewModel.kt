package com.example.middlecourseproject.presentation.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.useCases.GetLanguageUseCase
import com.example.middlecourseproject.domain.useCases.GetThemeUseCase
import com.example.middlecourseproject.domain.useCases.SignOutUseCase
import com.example.middlecourseproject.domain.useCases.ThemeToggleUseCase
import com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase,
    private val toggleLanguageUseCase: ToggleLanguageUseCase,
    private val getLanguageUseCase: GetLanguageUseCase,
    private val themeToggleUseCase: ThemeToggleUseCase,
    private val getThemeUseCase: GetThemeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ProfileSideEffect>(replay = 0)
    val sideEffect: SharedFlow<ProfileSideEffect> = _sideEffect.asSharedFlow()

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        viewModelScope.launch {
            try {
                val currentLanguage = getLanguageUseCase()
                val isDarkMode = getThemeUseCase()

                Log.d("ProfileViewModel", "Initial state - language: $currentLanguage, dark mode: $isDarkMode")

                _state.value = _state.value.copy(
                    currentLanguage = currentLanguage,
                    isDarkMode = isDarkMode
                )
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error loading initial state", e)
            }
        }
    }

    fun processIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.SignOut -> handleSignOut()
            is ProfileIntent.ToggleTheme -> toggleTheme()
            is ProfileIntent.ToggleLanguage -> toggleLanguage()
        }
    }

    private fun handleSignOut() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                signOutUseCase()
                _sideEffect.emit(ProfileSideEffect.ShowSnackbar("Signed out successfully"))
                _sideEffect.emit(ProfileSideEffect.NavigateToLogin)
            } catch (e: Exception) {
                _sideEffect.emit(ProfileSideEffect.ShowSnackbar("Sign out failed: ${e.message}"))
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }

    private fun toggleTheme() {
        viewModelScope.launch {
            try {
                Log.d("ProfileViewModel", "Toggling theme")
                val isDarkMode = themeToggleUseCase()
                Log.d("ProfileViewModel", "Theme toggled, new value: $isDarkMode")
                _state.value = _state.value.copy(isDarkMode = isDarkMode)
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "Error toggling theme", e)
                _sideEffect.emit(ProfileSideEffect.ShowSnackbar("Error toggling theme: ${e.message}"))
            }
        }
    }

    private fun toggleLanguage() {
        viewModelScope.launch {
            try {
                val newLang = toggleLanguageUseCase()
                _state.value = _state.value.copy(currentLanguage = newLang)
                _sideEffect.emit(ProfileSideEffect.LanguageToggled(newLang))
            } catch (e: Exception) {
                _sideEffect.emit(ProfileSideEffect.ShowSnackbar("Error toggling language: ${e.message}"))
            }
        }
    }
}