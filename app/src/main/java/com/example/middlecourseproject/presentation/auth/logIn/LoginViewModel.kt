package com.example.middlecourseproject.presentation.auth.logIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.useCases.GetLanguageUseCase
import com.example.middlecourseproject.domain.useCases.LoginUseCase
import com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.presentation.utils.ErrorMapper
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
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val toggleLanguageUseCase: ToggleLanguageUseCase,
    private val getLanguageUseCase: GetLanguageUseCase,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<LoginSideEffect>(replay = 0)
    val sideEffect: SharedFlow<LoginSideEffect> = _sideEffect.asSharedFlow()

    init {
        loadLanguage()
    }

    private fun loadLanguage() {
        viewModelScope.launch {
            val lang = getLanguageUseCase()
            _state.value = _state.value.copy(currentLanguage = lang)
        }
    }

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EnterEmail -> _state.value = _state.value.copy(
                email = intent.email,
                emailError = null
            )
            is LoginIntent.EnterPassword -> _state.value = _state.value.copy(
                password = intent.password,
                passwordError = null
            )
            is LoginIntent.ClickLogin -> handleLogin()
            is LoginIntent.ClickRegister -> viewModelScope.launch {
                _sideEffect.emit(LoginSideEffect.NavigateToRegister)
            }
            is LoginIntent.ToggleLanguage -> toggleLanguage()
        }
    }

    private fun handleLogin() {
        val email = _state.value.email
        val password = _state.value.password

        val emailError = when {
            email.isEmpty() -> "Email cannot be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email"
            else -> null
        }
        val passwordError = if (password.isEmpty()) "Password cannot be empty" else null

        if (emailError != null || passwordError != null) {
            _state.value = _state.value.copy(
                emailError = emailError,
                passwordError = passwordError
            )
            return
        }

        viewModelScope.launch {
            loginUseCase(email, password).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(isLoading = false)

                        // The token should already be saved in your AuthRepositoryImpl
                        // If not, you'll need to inject TokenRepository and save it here

                        _sideEffect.emit(LoginSideEffect.NavigateToHome)
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isLoading = false)
                        val errorMessage = errorMapper.mapToMessage(resource.message)
                        _sideEffect.emit(LoginSideEffect.ShowSnackbar(errorMessage))
                    }
                }
            }
        }
    }

    private fun toggleLanguage() {
        viewModelScope.launch {
            val newLang = toggleLanguageUseCase()
            _state.value = _state.value.copy(currentLanguage = newLang)
            _sideEffect.emit(LoginSideEffect.LanguageToggled(newLang))
        }
    }
}