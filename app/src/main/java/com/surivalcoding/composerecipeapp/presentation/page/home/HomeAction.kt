package com.surivalcoding.composerecipeapp.presentation.page.home

import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category

sealed interface HomeAction {
    data class FilterCategory(val pickerState: PickerState) : HomeAction
    data object SearchRecipe : HomeAction
}