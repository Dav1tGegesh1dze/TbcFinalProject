package com.example.middlecourseproject.presentation.auth.details

sealed class DetailsSideEffect {
    data class ShowError(val message: String) : DetailsSideEffect()
    data object NavigateToHome : DetailsSideEffect()
    data object LaunchGalleryPicker : DetailsSideEffect()
    data object LaunchCamera : DetailsSideEffect()
    data object ShowCameraPermissionRationale : DetailsSideEffect()
    data object ShowCameraPermissionDenied : DetailsSideEffect()
}