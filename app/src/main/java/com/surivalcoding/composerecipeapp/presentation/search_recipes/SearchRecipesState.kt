package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.component.filter_bottomsheet.FilterState

data class SearchRecipesState(
    val query : String = "",
    val recipes: List<Recipe> = emptyList(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val filterState: FilterState = FilterState(),
    val showFilterSheet: Boolean = false,
    val resultTitle: String = "Recent Search",
    val resultCount: String = "",
)