package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

sealed interface RecipeDetailAction {
    data class FilterCategory(val recipeDetailButtonState: RecipeDetailButtonState) : RecipeDetailAction
}