package com.surivalcoding.composerecipeapp.data.saved_recipe.data_source

import com.surivalcoding.composerecipeapp.data.saved_recipe.dto.RecipeDto

interface RecipeDatasource {
    suspend fun getSavedRecipes(): List<RecipeDto>
}