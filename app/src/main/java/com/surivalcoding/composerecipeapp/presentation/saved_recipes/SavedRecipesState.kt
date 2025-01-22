package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import com.surivalcoding.composerecipeapp.data.model.Recipe

data class SavedRecipesState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false

)