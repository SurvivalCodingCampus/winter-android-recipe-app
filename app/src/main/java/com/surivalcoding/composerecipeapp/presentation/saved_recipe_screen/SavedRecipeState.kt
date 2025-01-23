package com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen

import com.surivalcoding.composerecipeapp.data.model.Recipe

data class SavedRecipeState(
    val savedRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val isBookmark: Boolean = true,
)