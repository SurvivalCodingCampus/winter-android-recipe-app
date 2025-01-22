package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.flow.Flow

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    override fun getSearchRecipes(query: String): Flow<List<SearchRecipe>> =
        recipeDataSource.getSearchRecipes(query)

    override fun getSavedRecipes(ids: List<Int>): Flow<List<SavedRecipe>> =
        recipeDataSource.getSavedRecipe(ids)
}