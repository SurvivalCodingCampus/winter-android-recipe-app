package com.surivalcoding.composerecipeapp.data.data_source

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto

interface RecipeDatasource {
    suspend fun getRecipes(): List<RecipeDto>
    suspend fun removeRecipes(recipeId: Int)
}