package com.surivalcoding.composerecipeapp.domain.usecase.recipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class SearchRecipeUseCase(
    private val recipeRepository: RecipeRepository
) {
    suspend fun execute(): List<Recipe> {
        return recipeRepository.getAllRecipes()
    }
}