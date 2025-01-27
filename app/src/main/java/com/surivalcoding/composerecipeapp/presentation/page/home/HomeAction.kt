package com.surivalcoding.composerecipeapp.presentation.page.home

sealed interface HomeAction {
    data object SearchRecipe : HomeAction
    data object FilterCategory : HomeAction
}