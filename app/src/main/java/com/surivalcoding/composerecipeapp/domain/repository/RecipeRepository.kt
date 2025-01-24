package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): List<Recipe>
}