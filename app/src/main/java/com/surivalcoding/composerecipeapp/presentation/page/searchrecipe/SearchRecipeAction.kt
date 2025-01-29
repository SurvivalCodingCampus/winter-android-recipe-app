package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

sealed interface SearchRecipeAction {
    data class FilterSearchChange(val value: String) : SearchRecipeAction
    data class HandleBottomSheet(val isBottomSheetVisible: Boolean) : SearchRecipeAction
    data class SearchRecipeDetail(val recipeDetail: Recipe) : SearchRecipeAction
}