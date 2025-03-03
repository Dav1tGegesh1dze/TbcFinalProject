package com.example.middlecourseproject.data.utils
import android.content.Context
import android.util.Log
import com.example.middlecourseproject.R
import com.example.middlecourseproject.data.remote.dtos.ErrorResponse
import com.example.middlecourseproject.data.local.Resource
import com.example.middlecourseproject.domain.StringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import retrofit2.Response
import kotlinx.serialization.json.Json
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ApiHelper @Inject constructor(
    private val stringProvider: StringProvider


) {
    private fun getErrorMessageFromType(errorType: String?, httpCode: Int? = null): String {
        return when {

            errorType == "NOT_CORRECT_EMAIL_OR_PASSWORD" -> stringProvider.getString(R.string.incorect_email_or_password)
            errorType == "ALREADY_USED_EMAILADDRESS" -> stringProvider.getString(R.string.already_registered_email)
            errorType == "OTP_ERROR_VALID" -> stringProvider.getString(R.string.invalid_otp)
            errorType == "OTP_ERROR_CORRECT" -> stringProvider.getString(R.string.invalid_otp1)
            httpCode == 401 -> stringProvider.getString(R.string.expired_jwt)
            else -> stringProvider.getString(R.string.other_error)
        }
    }
    suspend fun <T> handleHttpRequest(httpCall: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = httpCall.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error(stringProvider.getString(R.string.empty_response))
            } else {
                val errorBody = response.errorBody()?.string()
                val errorMessage = if (!errorBody.isNullOrBlank()) {
                    try {
                        val errorResponse = Json { ignoreUnknownKeys = true }
                            .decodeFromString<ErrorResponse>(errorBody)
                        getErrorMessageFromType(errorResponse.errorType, response.code())
                    } catch (e: Exception) {
                        stringProvider.getString(R.string.error_parsing)
                    }
                } else {
                    // No error body, fall back to HTTP status code
                    getErrorMessageFromType(null, response.code())
                }
                Resource.Error(errorMessage)
            }
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is SocketTimeoutException -> stringProvider.getString(R.string.request_timed_out)
                is UnknownHostException -> stringProvider.getString(R.string.internet_error)
                is HttpException -> "Server error: ${e.message()}"
                else -> "Unexpected error: ${e.localizedMessage ?: "Please try again"}"
            }
            Resource.Error(errorMessage)
        }
    }
}