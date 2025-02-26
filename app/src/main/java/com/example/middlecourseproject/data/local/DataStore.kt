package com.example.middlecourseproject.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "MyAppPrefs")

class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.dataStore

    companion object {
        val JWT_TOKEN = stringPreferencesKey("jwt_token")

    }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[JWT_TOKEN] = token
        }
    }



    fun getToken(): Flow<String?> =
        dataStore.data.map { it[JWT_TOKEN] }


    suspend fun clearData() {
        dataStore.edit { it.clear() }
    }


}
