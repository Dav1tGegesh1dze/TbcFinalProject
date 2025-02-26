package com.example.middlecourseproject.data.utils
import com.example.middlecourseproject.data.remote.dtos.ErrorResponse
import com.example.middlecourseproject.data.local.Resource
import retrofit2.HttpException
import retrofit2.Response
import kotlinx.serialization.json.Json
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ApiHelper @Inject constructor() {
    private fun getErrorMessageFromType(errorType: String?, httpCode: Int? = null): String {
        return when {
            errorType == "NOT_CORRECT_EMAIL_OR_PASSWORD" -> "Incorrect email or password. Please try again."
            errorType == "ALREADY_USED_EMAILADDRESS" -> "This email is already registered. Please use a different email."
            errorType == "OTP_ERROR_VALID" -> "Invalid OTP. Please check and try again."
            httpCode == 401 -> "Session expired. Please log in again."
            else -> "An unexpected error occurred. Please try again."
        }
    }
    suspend fun <T> handleHttpRequest(httpCall: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = httpCall.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error("Empty response")
            } else {
                val errorBody = response.errorBody()?.string()
                val errorMessage = if (!errorBody.isNullOrBlank()) {
                    try {
                        val errorResponse = Json { ignoreUnknownKeys = true }
                            .decodeFromString<ErrorResponse>(errorBody)
                        getErrorMessageFromType(errorResponse.errorType, response.code())
                    } catch (e: Exception) {
                        "Error parsing response. Please try again."
                    }
                } else {
                    // No error body, fall back to HTTP status code
                    getErrorMessageFromType(null, response.code())
                }
                Resource.Error(errorMessage)
            }
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is SocketTimeoutException -> "Request timed out. Please try again."
                is UnknownHostException -> "No internet connection. Please check your network."
                is HttpException -> "Server error: ${e.message()}"
                else -> "Unexpected error: ${e.localizedMessage ?: "Please try again"}"
            }
            Resource.Error(errorMessage)
        }
    }
}