package com.surivalcoding.composerecipeapp.domain.model

data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Float,
    val ingredients: List<IngredientAmount>,
    val isBookmarked: Boolean = false
)