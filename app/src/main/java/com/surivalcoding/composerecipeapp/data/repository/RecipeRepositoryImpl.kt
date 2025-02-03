package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.local.mock.MockRecipeData
import com.surivalcoding.composerecipeapp.domain.model.RecipeItem
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mockRecipeData: MockRecipeData
) : RecipeRepository {
    override suspend fun getRecipes(): List<RecipeItem> {
        delay(MOCK_DELAY_MS)
        return mockRecipeData.mockRecipes
    }

    override suspend fun getRecipeDetail(id: String): RecipeItem {
        delay(MOCK_DELAY_MS)
        return mockRecipeData.mockRecipes.firstOrNull { it.id == id }
            ?: throw NoSuchElementException("Recipe not found with id: $id")
    }

    companion object {
        private const val MOCK_DELAY_MS = 2_000L
    }
}