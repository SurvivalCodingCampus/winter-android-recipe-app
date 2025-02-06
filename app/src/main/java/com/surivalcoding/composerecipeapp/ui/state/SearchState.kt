package com.surivalcoding.composerecipeapp.ui.state

import com.surivalcoding.composerecipeapp.domain.model.RecipeItem

data class SearchState(
    val isLoading: Boolean = false,
    val recipes: List<RecipeItem> = emptyList(),
    val query: String = "",
    val filteredRecipes: List<RecipeItem> = emptyList()
)