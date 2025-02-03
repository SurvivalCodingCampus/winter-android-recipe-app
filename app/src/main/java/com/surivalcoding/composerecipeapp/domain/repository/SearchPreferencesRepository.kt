package com.surivalcoding.composerecipeapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface SearchPreferencesRepository {
    suspend fun saveLastSearchKeyword(query: String)
    fun getLastSearchKeyword(): Flow<String?>
}