package com.plum.salesacademy.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("plum_session")
class SessionStore(private val context: Context) {
    companion object { val USER_ID = stringPreferencesKey("user_id"); val TOKEN = stringPreferencesKey("token") }
    val session = context.dataStore.data.map { it[USER_ID] to it[TOKEN] }
    suspend fun save(userId: String, token: String) = context.dataStore.edit { it[USER_ID] = userId; it[TOKEN] = token }
}
