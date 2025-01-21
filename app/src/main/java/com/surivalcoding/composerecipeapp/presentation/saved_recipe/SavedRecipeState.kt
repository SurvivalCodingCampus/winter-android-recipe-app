package com.surivalcoding.composerecipeapp.presentation.saved_recipe

import com.surivalcoding.composerecipeapp.data.model.Recipe

data class SavedRecipeState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
)