package com.surivalcoding.composerecipeapp.data.saved_recipe.model

data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Float,
    val ingredients: List<IngredientAmount>
)