package com.example.middlecourseproject.data.repository

import com.example.middlecourseproject.domain.models.LogInDomain
import com.example.middlecourseproject.domain.models.RegisterDomain
import com.example.middlecourseproject.domain.repository.AuthRepository
import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.domain.utils.AppError
import com.example.middlecourseproject.domain.utils.ErrorType
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override suspend fun register(email: String,  password: String): Flow<Resource<RegisterDomain>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                val user = result.user
                if (user != null) {
                    user.sendEmailVerification().await()
                    firebaseAuth.signOut()
                    emit(Resource.Success(RegisterDomain(success = true)))
                } else {
                    emit(Resource.Error(AppError.ApiError(ErrorType.OTHER, "User creation failed")))
                }
            } catch (e: FirebaseAuthException) {
                val errorType = mapFirebaseErrorToErrorType(e.errorCode)
                emit(Resource.Error(AppError.ApiError(errorType, e.message)))
            } catch (e: Exception) {
                emit(Resource.Error(AppError.ApiError(ErrorType.OTHER, e.message ?: "Unknown error")))
            }
        }
    }

    override suspend fun login(email: String, password: String): Flow<Resource<LogInDomain>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                val user = result.user
                if (user != null) {
                    emit(Resource.Success(LogInDomain(uid = user.uid)))
                } else {
                    emit(Resource.Error(AppError.ApiError(ErrorType.OTHER, "Login failed")))
                }
            } catch (e: FirebaseAuthException) {
                val errorType = mapFirebaseErrorToErrorType(e.errorCode)
                emit(Resource.Error(AppError.ApiError(errorType, e.message)))
            } catch (e: Exception) {
                emit(Resource.Error(AppError.ApiError(ErrorType.OTHER, e.message ?: "Unknown error")))
            }
        }
    }

    private fun mapFirebaseErrorToErrorType(errorCode: String): ErrorType {
        return when (errorCode) {
            "ERROR_INVALID_EMAIL",
            "ERROR_WRONG_PASSWORD",
            "ERROR_USER_NOT_FOUND" -> ErrorType.NOT_CORRECT_EMAIL_OR_PASSWORD
            "ERROR_EMAIL_ALREADY_IN_USE" -> ErrorType.ALREADY_USED_EMAILADDRESS
            else -> ErrorType.OTHER
        }
    }
}