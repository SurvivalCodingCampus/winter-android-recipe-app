package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.mapper.toRecipe
import com.surivalcoding.composerecipeapp.data.model.Recipe
import kotlinx.coroutines.delay

class MockRecipeRepositoryImpl(private val datasource: RecipeDatasource) : RecipeRepository {
    override suspend fun getRecipeList(): List<Recipe> {
        return datasource.getRecipeList()
            .map { it!!.toRecipe() }
    }
}