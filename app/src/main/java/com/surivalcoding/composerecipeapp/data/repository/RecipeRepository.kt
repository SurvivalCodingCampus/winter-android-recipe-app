package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.model.Recipe

interface RecipeRepository {
    suspend fun getSavedRecipes(): List<Recipe>
}