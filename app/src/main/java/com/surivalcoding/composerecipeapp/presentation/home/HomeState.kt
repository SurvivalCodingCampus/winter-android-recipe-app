package com.surivalcoding.composerecipeapp.presentation.home

import Recipe
import com.surivalcoding.composerecipeapp.navigation.Route


data class HomeState(
    val keyword: String = "",
    val isSelected: Route,
    val recipeList: List<Recipe> = emptyList(),
    val filteredRecipeList: List<Recipe> = emptyList(),
    val isLoading: Boolean = true,
    val isSearching: Boolean = false,
)
