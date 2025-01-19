package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.toSavedRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {
    private val savedRecipes = mutableListOf<SavedRecipe>()
    override fun getSavedRecipes(ids: List<Int>): Flow<List<SavedRecipe>> = flow {
        ids.forEach {
            recipeDataSource.getSavedRecipe(it).collect { recipe ->
                savedRecipes.add(recipe.toSavedRecipe())
                emit(savedRecipes)
            }
        }
    }
}