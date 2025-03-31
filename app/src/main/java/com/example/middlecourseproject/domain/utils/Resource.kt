package com.example.middlecourseproject.domain.utils


sealed class Resource<out T> {
    data object Idle : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: AppError) : Resource<Nothing>()
}