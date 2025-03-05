package com.example.middlecourseproject.presentation.auth.otpValidation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.useCases.ResendOtpUseCase
import com.example.middlecourseproject.domain.useCases.ValidateOtpUseCase
import com.example.middlecourseproject.domain.utils.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpValidationViewModel @Inject constructor(
    private val validateOtpUseCase: ValidateOtpUseCase,
    private val resendOtpUseCase: ResendOtpUseCase,
    private val stringProvider: StringProvider
) : ViewModel() {

    private val _timerSeconds = MutableStateFlow(180) // 3 minute
    val timerSeconds: StateFlow<Int> get() = _timerSeconds

    private val _otpSuccessEvent = MutableSharedFlow<Unit>(replay = 0)
    val otpSuccessEvent = _otpSuccessEvent.asSharedFlow()

    private val _otpErrorEvent = MutableSharedFlow<String>(replay = 0)
    val otpErrorEvent = _otpErrorEvent.asSharedFlow()

    private val _resendEvent = MutableSharedFlow<Resource<Boolean>>(replay = 0)
    val resendEvent = _resendEvent.asSharedFlow()

    private var timerJob: Job? = null

    init {
        startTimer()
    }

    private fun startTimer() {
        timerJob?.cancel()
        _timerSeconds.value = 180
        timerJob = viewModelScope.launch(Dispatchers.IO) {
            while (_timerSeconds.value > 0) {
                delay(1000)
                _timerSeconds.value -= 1
            }
        }
    }

    fun validateOtp(otp: String, email: String, password: String) {
        if (_timerSeconds.value <= 0) {
            viewModelScope.launch { _otpErrorEvent.emit(stringProvider.getString(R.string.otp_expired)) }
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = validateOtpUseCase(otp,email,password)) {
                is Resource.Success -> _otpSuccessEvent.emit(Unit)
                is Resource.Error -> _otpErrorEvent.emit(result.message)
                else -> Unit
            }
        }
    }

    fun resendOtp(email: String, username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resendEvent.emit(Resource.Loading)
            when (val result = resendOtpUseCase(email, username, password)) {
                is Resource.Success -> {
                    _resendEvent.emit(Resource.Success(true))
                    startTimer()
                }
                is Resource.Error -> {
                    _otpErrorEvent.emit(result.message)
                    _resendEvent.emit(result)
                }
                else -> Unit
            }
        }
    }
}
