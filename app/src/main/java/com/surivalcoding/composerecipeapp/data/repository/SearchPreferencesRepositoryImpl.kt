package com.surivalcoding.composerecipeapp.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.surivalcoding.composerecipeapp.domain.repository.SearchPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchPreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SearchPreferencesRepository {

    companion object {
        private val LAST_SEARCH_KEYWORD_KEY = stringPreferencesKey("last_search_keyword")
    }

    // 마지막 검색어 저장
    override suspend fun saveLastSearchKeyword(query: String) {
        dataStore.edit { preferences ->
            preferences[LAST_SEARCH_KEYWORD_KEY] = query
        }
    }

    // 마지막 검색어 불러오기
    override fun getLastSearchKeyword(): Flow<String?> = dataStore.data.map { preferences ->
        preferences[LAST_SEARCH_KEYWORD_KEY]
    }
}