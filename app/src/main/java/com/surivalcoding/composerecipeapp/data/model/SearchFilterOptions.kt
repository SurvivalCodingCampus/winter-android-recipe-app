package com.surivalcoding.composerecipeapp.data.model

data class SearchFilterOptions(
    val time: TimeType,
    val rating: Int,
    val category: RecipeCategory,
)