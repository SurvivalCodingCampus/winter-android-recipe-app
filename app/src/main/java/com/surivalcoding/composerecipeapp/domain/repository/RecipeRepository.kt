package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipeById(recipeId: Int): Recipe?
    suspend fun getAllRecipes(): List<Recipe>
    suspend fun removeRecipes(recipeId: Int)
}
