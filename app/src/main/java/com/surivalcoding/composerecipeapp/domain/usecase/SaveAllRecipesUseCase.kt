package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveAllRecipesUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    suspend fun execute(recipes: List<Recipe>) = withContext(Dispatchers.IO) {
        savedRecipeRepository.saveRecipeList(recipes.map { it.toMapper() })
    }
}