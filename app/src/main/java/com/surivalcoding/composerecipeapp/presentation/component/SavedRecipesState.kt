package com.surivalcoding.composerecipeapp.presentation.component

import com.surivalcoding.composerecipeapp.presentation.component.model.Recipe

data class SavedRecipesState(
    val isLoading: Boolean = true,
    var foodImages: List<String> = emptyList(),
    var titles: List<String> = emptyList(),
    var chefNames: List<String> = emptyList(),
    var rates: List<Float> = emptyList(),
    var cookingTimeMinutes: List<Int> = emptyList(),
    var dataCount: Int = 0,

    var isSearching: Boolean = false,
)