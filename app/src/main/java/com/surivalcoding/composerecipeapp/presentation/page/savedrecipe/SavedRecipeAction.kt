package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

sealed interface SavedRecipeAction {
    data class DeleteBookmark(val recipeId: Int) : SavedRecipeAction
}