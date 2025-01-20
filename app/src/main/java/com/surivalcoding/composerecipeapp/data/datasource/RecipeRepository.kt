package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getSavedRecipes(ids: List<Int>): Flow<List<SavedRecipe>>
}