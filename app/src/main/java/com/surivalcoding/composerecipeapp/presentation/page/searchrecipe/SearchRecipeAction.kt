package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

sealed interface SearchRecipeAction {
    data class FilterSearchChange(val value: String) : SearchRecipeAction
    data class HandleBottomSheet(val isBottomSheetVisible: Boolean) : SearchRecipeAction
}