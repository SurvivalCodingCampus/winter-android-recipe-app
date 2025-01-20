package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    override fun getSavedRecipes(ids: List<Int>): Flow<List<SavedRecipe>> = flow {
        ids.forEach {
            recipeDataSource.getSavedRecipe(ids).collect { savedRecipe ->
                emit(savedRecipe)
            }
        }
    }
}