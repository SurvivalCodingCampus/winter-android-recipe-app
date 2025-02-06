package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    override fun getRecipes(): Flow<List<Recipe>> =
        recipeDataSource.getRecipes()

    override fun getRecipesByCategory(category: RecipeCategory): Flow<List<Recipe>> {
        val recipes = getRecipes()
        return if (category == RecipeCategory.ALL) {
            recipes
        } else {
            recipes.map { it -> it.filter { it.category == category } }
        }
    }
}