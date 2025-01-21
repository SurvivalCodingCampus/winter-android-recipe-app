package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto

interface RecipeDatasource {
    suspend fun getRecipeList(): List<RecipeDto?>

}