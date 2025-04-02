package com.example.middlecourseproject.presentation.auth.otpValidation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.useCases.ResendOtpUseCase
import com.example.middlecourseproject.domain.useCases.ValidateOtpUseCase
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.presentation.utils.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpValidationViewModel @Inject constructor(
    private val validateOtpUseCase: ValidateOtpUseCase,
    private val resendOtpUseCase: ResendOtpUseCase,
    private val stringProvider: StringProvider,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    private val _state = MutableStateFlow(OtpValidationState())
    val state: StateFlow<OtpValidationState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<OtpValidationSideEffect>(replay = 0)
    val sideEffect: SharedFlow<OtpValidationSideEffect> = _sideEffect.asSharedFlow()

    private var email: String = ""
    private var username: String = ""
    private var password: String = ""

    private var timerJob: Job? = null

    init {
        startTimer()
    }

    fun setCredentials(email: String, username: String, password: String) {
        this.email = email
        this.username = username
        this.password = password
    }

    private fun startTimer() {
        timerJob?.cancel()
        _state.value = _state.value.copy(timerSeconds = 180)
        timerJob = viewModelScope.launch {
            while (_state.value.timerSeconds > 0) {
                delay(1000)
                _state.value = _state.value.copy(timerSeconds = _state.value.timerSeconds - 1)
            }
        }
    }

    fun processIntent(intent: OtpValidationIntent) {
        when (intent) {
            is OtpValidationIntent.SubmitOtp -> handleSubmitOtp(intent.otp)
            is OtpValidationIntent.ResendOtp -> handleResendOtp()
        }
    }

    private fun handleSubmitOtp(otp: String) {
        if (_state.value.timerSeconds <= 0) {
            viewModelScope.launch {
                _sideEffect.emit(
                    OtpValidationSideEffect.ShowValidationError(
                        stringProvider.getString(R.string.otp_expired)
                    )
                )
            }
            return
        }
        viewModelScope.launch {
            validateOtpUseCase.invoke(otp, email, password).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isValidating = resource.isLoading)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(isValidating = false)
                        _sideEffect.emit(OtpValidationSideEffect.NavigateToDetails)
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isValidating = false)
                        val errorMessage = errorMapper.mapToMessage(resource.message)
                        _sideEffect.emit(OtpValidationSideEffect.ShowValidationError(errorMessage))
                    }
                }
            }
        }
    }

    private fun handleResendOtp() {
        viewModelScope.launch {
            resendOtpUseCase.invoke(email, username, password).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isResending = resource.isLoading)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(isResending = false)
                        startTimer()
                        _sideEffect.emit(OtpValidationSideEffect.ShowResendSuccess)
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isResending = false)
                        val errorMessage = errorMapper.mapToMessage(resource.message)
                        _sideEffect.emit(OtpValidationSideEffect.ShowResendError(errorMessage))
                    }
                }
            }
        }
    }

    override fun onCleared() {
        timerJob?.cancel()
        super.onCleared()
    }
}