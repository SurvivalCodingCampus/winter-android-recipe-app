package com.surivalcoding.composerecipeapp.presentation.component

data class SavedRecipesState(
    val isLoading: Boolean = true,
    var foodImages: List<String> = emptyList(),
    var titles: List<String> = emptyList(),
    var chefNames: List<String> = emptyList(),
    var rates: List<Float> = emptyList(),
    var cookingTimeMinutes: List<Int> = emptyList(),
    var dataCount: Int = 0
)