// LoginViewModel.kt
package com.example.middlecourseproject.presentation.auth.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.domain.useCases.GetLanguageUseCase
import com.example.middlecourseproject.domain.useCases.LoginUseCase
import com.example.middlecourseproject.domain.useCases.SaveLanguageUseCase
import com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class LoginEvent {
    object Success : LoginEvent()
    data class Error(val message: String) : LoginEvent()
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val toggleLanguageUseCase: ToggleLanguageUseCase,
    private val getLanguageUseCase: GetLanguageUseCase,
    private val saveLanguageUseCase: SaveLanguageUseCase
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _loginEvent = MutableSharedFlow<LoginEvent>(replay = 0)
    val loginEvent = _loginEvent.asSharedFlow()

    fun login(email: String, password: String) {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = loginUseCase(email, password)) {
                is Resource.Success -> _loginEvent.emit(LoginEvent.Success)
                is Resource.Error -> _loginEvent.emit(LoginEvent.Error(result.message))
                else -> Unit
            }
            _loading.value = false
        }
    }

    // Expose the current language code to update the UI.
    private val _language = MutableStateFlow("en")
    val language: StateFlow<String> get() = _language

    // One-time event to notify the view to recreate the activity.
    private val _languageToggleEvent = MutableSharedFlow<String>(replay = 0)
    val languageToggleEvent = _languageToggleEvent.asSharedFlow()

    // Load the current language using the repository.
    fun loadLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            _language.value = getLanguageUseCase()
        }
    }

    // Toggle language by calling the toggle use case.
    fun toggleLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            val newLang = toggleLanguageUseCase()
            _language.value = newLang
            _languageToggleEvent.emit(newLang)
        }
    }


}
