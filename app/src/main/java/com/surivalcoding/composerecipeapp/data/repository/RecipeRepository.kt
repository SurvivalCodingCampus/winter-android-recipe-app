package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult

interface RecipeRepository {
    suspend fun getRecipeList(): ResponseResult<List<Recipe>>
}