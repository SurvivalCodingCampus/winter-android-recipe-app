package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toRecipe
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor (private val dataSource: RecipeDataSource) : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
       return dataSource.getRecipes().map { it.toRecipe() }
    }
}