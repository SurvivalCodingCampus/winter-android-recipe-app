package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeDataSource {
    fun getSearchRecipes(query: String): Flow<List<SearchRecipe>>
    fun getSavedRecipe(ids: List<Int>): Flow<List<SavedRecipe>>
    fun getRecipes(): Flow<List<Recipe>>
}