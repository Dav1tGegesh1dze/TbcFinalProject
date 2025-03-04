package com.example.middlecourseproject.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.models.Profile
import com.example.middlecourseproject.domain.useCases.ClearTokenUseCase
import com.example.middlecourseproject.domain.useCases.GetProfileUseCase
import com.example.middlecourseproject.domain.useCases.UpdateDetailsUseCase
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

sealed class UpdateEvent {
    data object Success : UpdateEvent()
    data class Error(val message: String) : UpdateEvent()
}

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val clearTokenUseCase: ClearTokenUseCase,
    private val updateDetailsUseCase: UpdateDetailsUseCase
) : ViewModel() {

    private val _profile = MutableStateFlow<Resource<Profile>>(Resource.Idle)
    val profile: StateFlow<Resource<Profile>> = _profile.asStateFlow()

    private val _updateEvent = MutableSharedFlow<UpdateEvent>(replay = 0)
    val updateEvent = _updateEvent.asSharedFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private var currentProfile: Profile? = null

    fun fetchProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _profile.value = Resource.Loading
            val result = getProfileUseCase()
            if (result is Resource.Success) {
                currentProfile = result.data
            }
            _profile.value = result
        }
    }

    private val _logoutState = MutableStateFlow<Resource<Unit>>(Resource.Idle)
    val logoutState: StateFlow<Resource<Unit>> = _logoutState.asStateFlow()

    fun logout() {
        viewModelScope.launch {
            _logoutState.value = Resource.Loading
            try {
                clearTokenUseCase()
                delay(1000)
                _logoutState.value = Resource.Success(Unit)
            } catch (e: Exception) {
                _logoutState.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }


    fun updateProfile(newFirstName: String, newLastName: String, newProfilePhotoBase64: String?) {
        val profile = currentProfile
        if (profile == null) {
            viewModelScope.launch { _updateEvent.emit(UpdateEvent.Error("Profile not loaded")) }
            return
        }
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val finalPhoto = newProfilePhotoBase64?.let { "data:image/jpeg;base64,$it" }
            val request = DetailsRequest(
                firstName = newFirstName,
                lastName = newLastName,
                genderId = profile.genderId,
                homeStadiumId = 0,
                birthDate = profile.birthDate,
                cityId = profile.cityId,
                nationalityId = profile.nationalityId,
                profilePhoto = finalPhoto,
                bio = "",
                height = 0,
                weight = 0,
                freeTimeStart = null,
                freeTimeEnd = null
            )
            when (val result = updateDetailsUseCase(request)) {
                is Resource.Success -> {
                    currentProfile = profile.copy(
                        firstName = newFirstName,
                        lastName = newLastName,
                        profilePhotoUrl = newProfilePhotoBase64 ?: profile.profilePhotoUrl
                    )
                    _updateEvent.emit(UpdateEvent.Success)
                }
                is Resource.Error -> {
                    _updateEvent.emit(UpdateEvent.Error(result.message))
                }
                else -> Unit
            }
            _loading.value = false
        }
    }
}
