package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.dto.RecipeResponse
import com.surivalcoding.composerecipeapp.util.Urls
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class MockRecipeDataSourceImpl : RecipeDataSource {
    override suspend fun getRecipeList(): List<RecipeDto> = withContext(Dispatchers.IO) {
        val data = Urls.RECIPE_JSON

        return@withContext Json.decodeFromString<RecipeResponse>(data).recipes?.filterNotNull() ?: emptyList()
    }
}