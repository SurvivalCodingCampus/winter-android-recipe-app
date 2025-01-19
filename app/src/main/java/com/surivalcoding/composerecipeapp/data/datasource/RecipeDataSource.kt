package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeDataSource {
    fun getSavedRecipe(id:Int): Flow<Recipe>
}