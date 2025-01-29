package com.surivalcoding.composerecipeapp.presentation.page.profile

import com.surivalcoding.composerecipeapp.presentation.page.home.HomeAction
import com.surivalcoding.composerecipeapp.presentation.page.home.PickerState

sealed interface ProfileAction {
    data object MoreButton : ProfileAction
    data class FilterCategory(val filterButtonState: FilterButtonState) : ProfileAction
}