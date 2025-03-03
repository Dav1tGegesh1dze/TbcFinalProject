package com.example.middlecourseproject.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.data.local.Resource
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
    object Success : UpdateEvent()
    data class Error(val message: String) : UpdateEvent()
}

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val clearTokenUseCase: ClearTokenUseCase,
    private val updateDetailsUseCase: UpdateDetailsUseCase
) : ViewModel() {

    // Holds the fetched profile.
    private val _profile = MutableStateFlow<Resource<Profile>>(Resource.Idle)
    val profile: StateFlow<Resource<Profile>> = _profile.asStateFlow()

    // Update event for one-time update success or error.
    private val _updateEvent = MutableSharedFlow<UpdateEvent>(replay = 0)
    val updateEvent = _updateEvent.asSharedFlow()

    // Persistent loading state (used for both fetch and update).
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    // Keep the current profile so that non-edited fields are retained.
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

    /**
     * Updates profile with new firstName, lastName, and optionally a new profile image.
     * Other fields (genderId, birthDate, cityId, nationalityId) are taken from the currentProfile.
     */
    fun updateProfile(newFirstName: String, newLastName: String, newProfilePhotoBase64: String?) {
        val profile = currentProfile
        if (profile == null) {
            viewModelScope.launch { _updateEvent.emit(UpdateEvent.Error("Profile not loaded")) }
            return
        }
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            // Format the image data if available.
            val finalPhoto = newProfilePhotoBase64?.let { "data:image/jpeg;base64,$it" }
            // Build the request using new values for first and last names.
            val request = DetailsRequest(
                firstName = newFirstName,
                lastName = newLastName,
                genderId = profile.genderId,
                homeStadiumId = 0, // default value
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
                    // Update the current profile with the new names and image.
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
