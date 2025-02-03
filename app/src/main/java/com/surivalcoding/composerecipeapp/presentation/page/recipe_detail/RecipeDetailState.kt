package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class RecipeDetailState(
    val recipeDetail: Recipe? = null,
    val recipeCategoryButtonState: RecipeDetailButtonState = RecipeDetailButtonState()
)