package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.domain.model.RecipeItem

interface RecipeRepository {
    suspend fun getRecipes(): List<RecipeItem>
    suspend fun getRecipeDetail(id: String): RecipeItem
}