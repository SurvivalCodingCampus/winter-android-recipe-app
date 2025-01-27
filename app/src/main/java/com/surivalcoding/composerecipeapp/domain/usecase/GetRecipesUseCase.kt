package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.model.RecipeItem
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(): List<RecipeItem> {
        return repository.getRecipes()
    }
}