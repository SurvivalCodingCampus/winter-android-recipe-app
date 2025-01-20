package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SearchRecipesState(
    val recipeList: List<Recipe> = emptyList()
)
