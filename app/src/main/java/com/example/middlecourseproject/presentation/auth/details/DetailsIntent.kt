package com.example.middlecourseproject.presentation.auth.details

sealed class DetailsIntent {
    data class UpdateFirstName(val firstName: String) : DetailsIntent()
    data class UpdateLastName(val lastName: String) : DetailsIntent()
    data class UpdateBirthDate(val birthDate: String) : DetailsIntent()
    data class UpdateGender(val genderId: Int) : DetailsIntent()
    data class UpdateCity(val cityId: Int) : DetailsIntent()
    data class UpdateNationality(val nationalityId: Int) : DetailsIntent()
    data class UpdateProfilePhoto(val base64: String) : DetailsIntent()
    data object SaveDetails : DetailsIntent()
    data object PickImageFromGallery : DetailsIntent()
    data object TakePhoto : DetailsIntent()
    data object RequestCameraPermission : DetailsIntent()
}