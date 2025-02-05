package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

sealed interface RecipeDetailAction {
    data class FilterCategory(val recipeDetailButtonState: RecipeDetailButtonState) : RecipeDetailAction
    data class HandleDropDown(val isDropDownMenuVisible: Boolean) : RecipeDetailAction
    data class CopyLink(val link: String) : RecipeDetailAction
    data class HandleDialog(val isVisible: Boolean) : RecipeDetailAction
}