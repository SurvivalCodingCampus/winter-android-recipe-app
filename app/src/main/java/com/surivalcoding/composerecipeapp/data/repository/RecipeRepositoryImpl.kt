package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toRecipe
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(private val dataSource: RecipeDataSource) : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
        delay(1000)
       return dataSource.getRecipes().map { it.toRecipe() }
    }
}