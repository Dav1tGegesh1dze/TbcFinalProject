package com.example.middlecourseproject.presentation.auth.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.useCases.GetLanguageUseCase
import com.example.middlecourseproject.domain.useCases.LoginUseCase
import com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class LoginEvent {
    data object Success : LoginEvent()
    data class Error(val message: String) : LoginEvent()
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val toggleLanguageUseCase: ToggleLanguageUseCase,
    private val getLanguageUseCase: GetLanguageUseCase,
    private val errorMapper: ErrorMapper
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
                is Resource.Error -> {
                    val errorMessage = errorMapper.mapToMessage(result.message)
                    _loginEvent.emit(LoginEvent.Error(errorMessage))
                }
                else -> Unit
            }
            _loading.value = false
        }
    }

    private val _language = MutableStateFlow("en")
    val language: StateFlow<String> get() = _language

    private val _languageToggleEvent = MutableSharedFlow<String>(replay = 0)
    val languageToggleEvent = _languageToggleEvent.asSharedFlow()

    fun loadLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            _language.value = getLanguageUseCase()
        }
    }

    fun toggleLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            val newLang = toggleLanguageUseCase()
            _language.value = newLang
            _languageToggleEvent.emit(newLang)
        }
    }
}