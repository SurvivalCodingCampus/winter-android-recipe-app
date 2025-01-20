package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto

interface RecipeDataSource {
    suspend fun getRecipeList(): List<RecipeDto>
}