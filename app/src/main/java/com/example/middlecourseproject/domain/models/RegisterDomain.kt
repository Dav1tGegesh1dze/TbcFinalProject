package com.example.middlecourseproject.domain.models


data class RegisterDomain(
    val errorType : String?,
    val errorMessage : String?,
    val result : Boolean
)