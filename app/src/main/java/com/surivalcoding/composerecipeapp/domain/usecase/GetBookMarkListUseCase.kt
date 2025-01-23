package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetBookMarkListUseCase(
    private val bookmarkRepository: BookmarkRepository
) {

    suspend fun execute(): ResponseResult<List<Recipe>> = withContext(Dispatchers.IO) {
        safeCall {
            bookmarkRepository.getBookMarkList()
        }
    }
}