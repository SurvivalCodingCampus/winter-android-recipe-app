package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMainRecipeListUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun execute() = withContext(Dispatchers.IO) {
        safeCall {
            recipeRepository.getRecipeList()
        }
    }
}