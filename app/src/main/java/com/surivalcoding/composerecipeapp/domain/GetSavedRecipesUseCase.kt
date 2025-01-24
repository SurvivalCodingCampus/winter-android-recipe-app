package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class GetSavedRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val bookmarkUseCase: CancelBookmarkUseCase,
) {
    suspend fun execute(id: Int = 0): List<Recipe> {
        return recipeRepository.getRecipes().filter {
            it.id in bookmarkUseCase.execute(id)
        }
    }
}