package com.surivalcoding.composerecipeapp.data.data_source

import Recipe
import RecipeDataSource

class RecipeDataSourceImpl : RecipeDataSource {
    override suspend fun getSearchRecipes(keyword: String): List<Recipe> {
        TODO("Not yet implemented")
    }

    override suspend fun createRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }

}