package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getSearchRecipes(query: String): Flow<List<SearchRecipe>>
    fun getSavedRecipes(ids: List<Int>): Flow<List<SavedRecipe>>
}