package com.surivalcoding.composerecipeapp.data.model

data class UserData(
    val selectedCategory: RecipeCategory,
    val bookmarkIds: Set<Int>,
)