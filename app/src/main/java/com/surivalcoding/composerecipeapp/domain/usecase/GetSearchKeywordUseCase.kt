package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SearchPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchKeywordUseCase @Inject constructor(
    private val searchPreferencesRepository: SearchPreferencesRepository
) {

    fun execute(): Flow<String?> {
        return searchPreferencesRepository.getLastSearchKeyword()
    }
}