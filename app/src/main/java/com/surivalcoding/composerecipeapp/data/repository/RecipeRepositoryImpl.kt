package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    override suspend fun getRecipeList(): ResponseResult<List<Recipe>> = withContext(Dispatchers.IO) {
        safeCall {
            recipeDataSource.getRecipeList().map { it.toMapper() }
        }
    }
}