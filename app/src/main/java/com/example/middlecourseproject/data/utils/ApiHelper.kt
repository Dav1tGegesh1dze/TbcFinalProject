package com.example.middlecourseproject.data.utils

import com.example.middlecourseproject.data.remote.dtos.ErrorResponse
import com.example.middlecourseproject.domain.utils.AppError
import com.example.middlecourseproject.domain.utils.ErrorType
import com.example.middlecourseproject.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import kotlinx.serialization.json.Json
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ApiHelper @Inject constructor() {

    private fun parseErrorType(errorType: String?): ErrorType {
        return when (errorType) {
            "NOT_CORRECT_EMAIL_OR_PASSWORD" -> ErrorType.NOT_CORRECT_EMAIL_OR_PASSWORD
            "ALREADY_USED_EMAILADDRESS" -> ErrorType.ALREADY_USED_EMAILADDRESS
            "OTP_ERROR_VALID" -> ErrorType.OTP_ERROR_VALID
            "OTP_ERROR_CORRECT" -> ErrorType.OTP_ERROR_CORRECT
            else -> ErrorType.OTHER
        }
    }

    fun <T> handleHttpRequest(httpCall: suspend () -> Response<T>): Flow<Resource<T>> = flow {

        emit(Resource.Loading(isLoading = true))

        try {
            val response = httpCall.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(response.body()!!))
                } ?: emit(Resource.Error(AppError.ApiError(ErrorType.OTHER)))
            } else {
                val errorBody = response.errorBody()?.string()
                val appError = if (!errorBody.isNullOrBlank()) {
                    try {
                        val errorResponse = Json { ignoreUnknownKeys = true }
                            .decodeFromString<ErrorResponse>(errorBody)
                        AppError.ApiError(parseErrorType(errorResponse.errorType), errorResponse.errorMessage)
                    } catch (e: Exception) {
                        AppError.ApiError(ErrorType.OTHER)
                    }
                } else {
                    when (response.code()) {
                        401 -> AppError.ApiError(ErrorType.EXPIRED_JWT)
                        else -> AppError.ApiError(ErrorType.OTHER)
                    }
                }
                emit(Resource.Error(appError))
            }
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            val appError = when (e) {
                is SocketTimeoutException -> AppError.TimeoutError
                is UnknownHostException -> AppError.NetworkError("No internet connection")
                is HttpException -> AppError.ApiError(ErrorType.OTHER)
                else -> AppError.ApiError(ErrorType.OTHER)
            }
            emit(Resource.Error(appError))
        }
        emit(Resource.Loading(isLoading = false))
    }
}