package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.data.model.Recipe

data class SearchRecipesState(
    val query : String = "",
    val recipes: List<Recipe> = emptyList(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val resultTitle: String = "Recent Search",
    val resultCount: String = "",
)