package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    suspend fun execute(id: Int) {
        savedRecipeRepository.addBookmark(id)
    }
}