package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    override suspend fun getRecipeList(): ResponseResult<List<Recipe>> = withContext(Dispatchers.IO) {

        // 프로그래스바를 위한 딜레이
        delay(2000L)


        safeCall {
            recipeDataSource.getRecipeList().map { it.toMapper() }
        }
    }
}