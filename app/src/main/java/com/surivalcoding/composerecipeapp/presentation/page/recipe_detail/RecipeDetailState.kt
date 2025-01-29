package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.page.profile.FilterButtonState

data class RecipeDetailState(
    val recipeDetail: Recipe ?= null,
    val filterButtonState: FilterButtonState = FilterButtonState()
)