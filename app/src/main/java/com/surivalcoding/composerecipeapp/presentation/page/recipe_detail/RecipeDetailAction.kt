package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import com.surivalcoding.composerecipeapp.presentation.page.profile.FilterButtonState
import com.surivalcoding.composerecipeapp.presentation.page.profile.ProfileAction

sealed interface RecipeDetailAction {
    data class FilterCategory(val filterButtonState: FilterButtonState) : RecipeDetailAction
}