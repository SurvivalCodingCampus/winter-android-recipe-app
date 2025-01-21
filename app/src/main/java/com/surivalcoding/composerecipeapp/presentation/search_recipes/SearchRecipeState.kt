package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.data.model.Recipe

data class SearchRecipeState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val searchText: String = "",
    val searchTitle: String = "Recent Search"
)
