package com.surivalcoding.composerecipeapp.domain.usecase.recipe

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository

class RemoveFromSavedRecipesUseCase(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(recipeId: Int) {
        bookmarkRepository.removeBookmark(recipeId)
    }
}