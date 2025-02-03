package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SearchPreferencesRepository
import javax.inject.Inject

class SaveSearchKeywordUseCase @Inject constructor(
    private val searchPreferencesRepository: SearchPreferencesRepository
) {
    suspend fun execute(query: String) {
        searchPreferencesRepository.saveLastSearchKeyword(query)
    }
}