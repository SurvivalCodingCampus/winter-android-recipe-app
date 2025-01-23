package com.surivalcoding.composerecipeapp.data.model

data class SearchFilterOptions(
    val time: TimeType,
    val rate: Int,
    val category: RecipeCategory
)