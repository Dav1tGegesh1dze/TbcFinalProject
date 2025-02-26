// DetailsViewModel.kt
package com.example.middlecourseproject.presentation.auth.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.data.local.DataStoreManager
import com.example.middlecourseproject.data.remote.dtos.DetailsRequest
import com.example.middlecourseproject.data.local.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.middlecourseproject.domain.useCases.UpdateDetailsUseCase


sealed class DetailsEvent {
    object Success : DetailsEvent()
    data class Error(val message: String) : DetailsEvent()
}

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val updateDetailsUseCase: UpdateDetailsUseCase,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    // Persistent loading state.
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    // One-time events: navigation on success or error messages.
    private val _detailsEvent = MutableSharedFlow<DetailsEvent>(replay = 0)
    val detailsEvent = _detailsEvent.asSharedFlow()

    fun updateDetails(
        firstName: String,
        lastName: String,
        genderId: Int,
        birthDate: String,  // "yyyy-MM-dd"
        cityId: Int,
        nationalityId: Int,
        profilePhotoBase64: String?
    ) {
        // Basic validation.
        if (firstName.isBlank() || lastName.isBlank() || birthDate.isBlank()) {
            viewModelScope.launch {
                _detailsEvent.emit(DetailsEvent.Error("All fields are required"))
            }
            return
        }
        val finalProfileImageString = profilePhotoBase64?.let { "data:image/jpeg;base64,$it" }


        // Build the request object.
        val request = DetailsRequest(
            firstName = firstName,
            lastName = lastName,
            genderId = genderId,
            homeStadiumId = 0, // Assuming default value.
            birthDate = birthDate,
            cityId = cityId,
            nationalityId = nationalityId,
            profilePhoto = finalProfileImageString,
//            bio = "",
//            height = 0,
//            weight = 0,
//            freeTimeStart = null,
//            freeTimeEnd = null
        )

        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = updateDetailsUseCase( request)) {
                is Resource.Success -> _detailsEvent.emit(DetailsEvent.Success)
                is Resource.Error -> _detailsEvent.emit(DetailsEvent.Error(result.message))
                else -> Unit
            }
            _loading.value = false
        }
    }
}
