package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SavedRecipesState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false
)