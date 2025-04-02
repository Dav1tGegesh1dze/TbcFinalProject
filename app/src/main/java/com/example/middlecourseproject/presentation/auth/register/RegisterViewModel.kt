package com.example.middlecourseproject.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.useCases.RegisterUseCase
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
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<RegisterSideEffect>(replay = 0)
    val sideEffect: SharedFlow<RegisterSideEffect> = _sideEffect.asSharedFlow()

    fun processIntent(intent: RegisterIntent) {
        when (intent) {
            is RegisterIntent.EnterEmail -> _state.value = _state.value.copy(
                email = intent.email,
                emailError = null
            )
            is RegisterIntent.EnterUserName -> _state.value = _state.value.copy(
                userName = intent.userName,
                userNameError = null
            )
            is RegisterIntent.EnterPassword -> _state.value = _state.value.copy(
                password = intent.password,
                passwordError = null
            )
            is RegisterIntent.ClickRegister -> handleRegister()
            is RegisterIntent.ClickLogin -> viewModelScope.launch {
                _sideEffect.emit(RegisterSideEffect.NavigateToLogin)
            }
        }
    }

    private fun handleRegister() {
        val email = _state.value.email
        val userName = _state.value.userName
        val password = _state.value.password

        // Basic validation
        val emailError = when {
            email.isEmpty() -> "Email cannot be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
            else -> null
        }
        val userNameError = if (userName.isEmpty()) "Username cannot be empty" else null
        val passwordError = if (password.isEmpty()) "Password cannot be empty" else null

        if (emailError != null || userNameError != null || passwordError != null) {
            _state.value = _state.value.copy(
                emailError = emailError,
                userNameError = userNameError,
                passwordError = passwordError
            )
            return
        }

        viewModelScope.launch {
            registerUseCase(email, userName, password).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(isLoading = false)
                        _sideEffect.emit(RegisterSideEffect.NavigateToOtpValidation(email, userName, password))
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isLoading = false)
                        val errorMessage = errorMapper.mapToMessage(resource.message)
                        _sideEffect.emit(RegisterSideEffect.ShowSnackbar(errorMessage))
                    }
                }
            }
        }
    }
}