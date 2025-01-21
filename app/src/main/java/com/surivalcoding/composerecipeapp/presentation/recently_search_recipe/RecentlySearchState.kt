package com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model

import Recipe

data class RecipeSearchState(
    val keyword: String = "",
    val recipeList: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
)
