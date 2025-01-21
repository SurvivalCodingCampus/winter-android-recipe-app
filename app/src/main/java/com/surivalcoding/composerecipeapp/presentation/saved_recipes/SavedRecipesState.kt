package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import Recipe

data class SavedRecipesState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false
)
