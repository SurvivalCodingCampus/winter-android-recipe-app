package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.model.RecipeItem
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class GetRecipesUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(): List<RecipeItem> {
        return repository.getRecipes()
    }
}