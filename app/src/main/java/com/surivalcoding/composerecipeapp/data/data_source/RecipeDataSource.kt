package com.surivalcoding.composerecipeapp.data.data_source

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto

interface RecipeDataSource {
    suspend fun getRecipeList(): List<RecipeDto>
}