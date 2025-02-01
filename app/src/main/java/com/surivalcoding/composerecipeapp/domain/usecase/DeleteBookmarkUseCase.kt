package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.repository.SavedRecipeRepository
import javax.inject.Inject


/*
* saved 화면 Usecase
* */
class DeleteBookmarkUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    suspend fun execute(id: Int) {
        savedRecipeRepository.deleteBookmark(id)
    }
}