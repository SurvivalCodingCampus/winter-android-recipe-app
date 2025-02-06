package com.surivalcoding.composerecipeapp.domain.usecase.recipe

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class RemoveFromSavedRecipesUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(recipeId: Int) {
        bookmarkRepository.removeBookmark(recipeId)
    }
}