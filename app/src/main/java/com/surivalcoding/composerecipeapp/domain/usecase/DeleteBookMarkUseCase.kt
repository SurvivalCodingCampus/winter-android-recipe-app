package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


/*
* saved 화면 Usecase
* */
class DeleteBookMarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(id: Int): ResponseResult<List<Recipe>> = withContext(Dispatchers.IO) {
        safeCall {
            bookmarkRepository.deleteBookmark(id)
        }
    }
}