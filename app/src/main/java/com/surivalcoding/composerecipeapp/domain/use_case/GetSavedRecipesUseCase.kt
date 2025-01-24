package com.surivalcoding.composerecipeapp.domain.use_case

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class GetSavedRecipesUseCase(
    private val recipeRepository: RecipeRepository,
    private val bookmarkRepository: BookmarkRepository
) {
    suspend fun execute(id: Int = 0): List<Recipe> {
        return recipeRepository.getRecipes().toSet().filter {
            it.id in bookmarkRepository.cancelBookmarkId(id) }
    }
}