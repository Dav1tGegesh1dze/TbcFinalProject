// RegisterViewModel.kt
package com.example.middlecourseproject.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.domain.useCases.LoginUseCase
import com.example.middlecourseproject.domain.useCases.RegisterUseCase
import com.example.middlecourseproject.presentation.auth.logIn.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class RegisterEvent {
    object Success : RegisterEvent()
    data class Error(val message: String) : RegisterEvent()
}

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase

) : ViewModel() {

    // UI persistent state: whether a request is loading.
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    // One-time events: navigation, error messages, etc.
    private val _registerEvent = MutableSharedFlow<RegisterEvent>(replay = 0)
    val registerEvent = _registerEvent.asSharedFlow()

    fun register(email: String, userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            when (val result = registerUseCase(email, userName, password)) {
                is Resource.Success -> _registerEvent.emit(RegisterEvent.Success)
                is Resource.Error -> _registerEvent.emit(RegisterEvent.Error(result.message))
                else -> Unit
            }
            _loading.value = false
        }
    }
}
