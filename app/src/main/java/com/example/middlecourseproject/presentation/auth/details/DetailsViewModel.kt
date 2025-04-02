package com.example.middlecourseproject.presentation.auth.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.domain.useCases.UpdateDetailsUseCase
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.presentation.utils.ErrorMapper
import com.example.middlecourseproject.presentation.utils.StringProvider
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
class DetailsViewModel @Inject constructor(
    private val updateDetailsUseCase: UpdateDetailsUseCase,
    private val errorMapper: ErrorMapper,
    private val stringProvider: StringProvider
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DetailsSideEffect>(replay = 0)
    val sideEffect: SharedFlow<DetailsSideEffect> = _sideEffect.asSharedFlow()

    val genderList = listOf("Male" to 1, "Female" to 2, "Other" to 3)
    val cityList = listOf("New York" to 1, "London" to 2, "Tokyo" to 3)
    val nationalityList = listOf("USA" to 1, "UK" to 2, "Japan" to 3)

    fun processIntent(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.UpdateFirstName -> _state.value = _state.value.copy(
                firstName = intent.firstName,
                firstNameError = null
            )
            is DetailsIntent.UpdateLastName -> _state.value = _state.value.copy(
                lastName = intent.lastName,
                lastNameError = null
            )
            is DetailsIntent.UpdateBirthDate -> _state.value = _state.value.copy(
                birthDate = intent.birthDate,
                birthDateError = null
            )
            is DetailsIntent.UpdateGender -> _state.value = _state.value.copy(
                genderId = intent.genderId,
                genderError = null
            )
            is DetailsIntent.UpdateCity -> _state.value = _state.value.copy(
                cityId = intent.cityId,
                cityError = null
            )
            is DetailsIntent.UpdateNationality -> _state.value = _state.value.copy(
                nationalityId = intent.nationalityId,
                nationalityError = null
            )
            is DetailsIntent.UpdateProfilePhoto -> _state.value = _state.value.copy(
                profilePhotoBase64 = intent.base64
            )
            is DetailsIntent.SaveDetails -> handleSaveDetails()
            is DetailsIntent.PickImageFromGallery -> viewModelScope.launch {
                _sideEffect.emit(DetailsSideEffect.LaunchGalleryPicker)
            }
            is DetailsIntent.TakePhoto -> handleTakePhoto()
            is DetailsIntent.RequestCameraPermission -> handleCameraPermissionRequest()
        }
    }

    private fun handleSaveDetails() {
        val state = _state.value
        val firstNameError = if (state.firstName.isEmpty()) "First name is required" else null
        val lastNameError = if (state.lastName.isEmpty()) "Last name is required" else null
        val birthDateError = if (state.birthDate.isEmpty()) "Birth date is required" else null
        val genderError = if (state.genderId == null) "Gender is required" else null
        val cityError = if (state.cityId == null) "City is required" else null
        val nationalityError = if (state.nationalityId == null) "Nationality is required" else null

        if (firstNameError != null || lastNameError != null || birthDateError != null ||
            genderError != null || cityError != null || nationalityError != null
        ) {
            _state.value = state.copy(
                firstNameError = firstNameError,
                lastNameError = lastNameError,
                birthDateError = birthDateError,
                genderError = genderError,
                cityError = cityError,
                nationalityError = nationalityError
            )
            return
        }

        viewModelScope.launch {
            val request = DetailsRequest(
                firstName = state.firstName,
                lastName = state.lastName,
                genderId = state.genderId!!,
                birthDate = state.birthDate,
                homeStadiumId = 0,
                cityId = state.cityId!!,
                nationalityId = state.nationalityId!!,
                profilePhoto = state.profilePhotoBase64
            )
            updateDetailsUseCase(request).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(isLoading = false)
                        _sideEffect.emit(DetailsSideEffect.NavigateToHome)
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isLoading = false)
                        val errorMessage = errorMapper.mapToMessage(resource.message)
                        _sideEffect.emit(DetailsSideEffect.ShowError(errorMessage))
                    }
                }
            }
        }
    }

    private fun handleTakePhoto() {
        viewModelScope.launch {
            _sideEffect.emit(DetailsSideEffect.LaunchCamera)
        }
    }

    private fun handleCameraPermissionRequest() {
        viewModelScope.launch {
            _sideEffect.emit(DetailsSideEffect.ShowCameraPermissionRationale)
        }
    }
}