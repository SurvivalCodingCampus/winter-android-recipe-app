package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.mapper.toRecipe
import com.surivalcoding.composerecipeapp.data.model.Recipe
import kotlinx.coroutines.delay

class MockRecipeRepositoryImpl(private val recipeDatasource: RecipeDatasource) : RecipeRepository {
    override suspend fun getSavedRecipes(): List<Recipe> {
        delay(3000)
        return recipeDatasource.getSavedRecipes()
            .map { it.toRecipe() }
    }
}
