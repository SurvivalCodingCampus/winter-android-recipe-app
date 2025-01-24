package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SearchRecipesState(
    val recipeList: List<Recipe> = emptyList(),
    val filteredRecipeList: List<Recipe> = emptyList()
)
