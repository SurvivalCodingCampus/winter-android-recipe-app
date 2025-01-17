package com.surivalcoding.composerecipeapp.data.saved_recipe.repository

import com.surivalcoding.composerecipeapp.data.saved_recipe.data_source.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.saved_recipe.mapper.toRecipe
import com.surivalcoding.composerecipeapp.data.saved_recipe.model.Recipe

class MockRecipeRepositoryImpl(private val recipeDatasource: RecipeDatasource) : RecipeRepository {
    override suspend fun getSavedRecipes(): List<Recipe> {
        return recipeDatasource.getSavedRecipes()
            .map { it.toRecipe() }
    }
}
