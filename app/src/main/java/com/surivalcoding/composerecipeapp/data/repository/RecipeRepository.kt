package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipesByCategory(category: RecipeCategory): Flow<List<Recipe>>
    fun getRecipes(): Flow<List<Recipe>>
}