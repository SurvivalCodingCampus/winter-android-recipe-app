package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import kotlinx.coroutines.flow.Flow

interface RecipeDataSource {
    fun getSavedRecipe(ids: List<Int>): Flow<List<SavedRecipe>>
}