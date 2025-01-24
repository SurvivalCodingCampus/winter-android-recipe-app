package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult

interface RecipeRepository {
    suspend fun getRecipeList(): List<Recipe>
}