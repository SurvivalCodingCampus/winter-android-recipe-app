package com.surivalcoding.composerecipeapp.domain.savedscreen

import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository

class GetSavedRecipesUseCase(
    private val recipeRepository: RecipeRepository,
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(id: Int = 0): List<Recipe> {
        return recipeRepository.getRecipes().toSet().filter {
            it.id in bookmarkRepository.cancelBookmarkId(id) }
    }
}