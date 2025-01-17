package com.surivalcoding.composerecipeapp.data.saved_recipe.repository

import com.surivalcoding.composerecipeapp.data.saved_recipe.model.Recipe

interface RecipeRepository {
    suspend fun getSavedRecipes(): List<Recipe>
}