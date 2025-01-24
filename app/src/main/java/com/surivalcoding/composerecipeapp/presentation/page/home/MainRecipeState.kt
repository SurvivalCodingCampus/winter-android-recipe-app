package com.surivalcoding.composerecipeapp.presentation.page.home

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class MainRecipeState(
    val recipeList: List<Recipe> = emptyList(),
    val filteredRecipeList: List<Recipe> = emptyList()
)
