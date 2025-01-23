package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.local.mock.MockRecipeData
import com.surivalcoding.composerecipeapp.domain.model.RecipeItem
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.delay

class RecipeRepositoryImpl : RecipeRepository {
    override suspend fun getRecipes(): List<RecipeItem> {
        delay(2000)
        return MockRecipeData.mockRecipes
    }

    override suspend fun getRecipeDetail(id: String): RecipeItem {
        return MockRecipeData.mockRecipes.first { it.id == id }
    }
}