package com.surivalcoding.composerecipeapp.data.repository.impl

import com.surivalcoding.composerecipeapp.data.data_source.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.mapper.toRecipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(private val recipeDatasource: RecipeDatasource) : RecipeRepository {
    override suspend fun getAllRecipes(): List<Recipe> {
        delay(2000)
        return recipeDatasource.getRecipes()
            .map { it.toRecipe() }
    }

    override suspend fun getRecipeById(recipeId: Int): Recipe? {
        val recipe = recipeDatasource.getRecipes().find { it.id == recipeId }
        return recipe?.toRecipe()
    }

    override suspend fun removeRecipes(recipeId: Int) {
        recipeDatasource.removeRecipes(recipeId)
    }
    
}
