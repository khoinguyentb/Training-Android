package com.example.train.data_store

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreManager(private val context: Context) {

    val Context.dataStore by preferencesDataStore(name = "user_preferences")

    private val USER_NAME_KEY = stringPreferencesKey("user_name")

    suspend fun saveUserName(userName: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = userName
        }
    }

    fun getUserName(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_NAME_KEY]
        }
    }
}
