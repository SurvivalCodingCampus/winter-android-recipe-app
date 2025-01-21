package com.surivalcoding.composerecipeapp.data.model


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


data class Ingredient(
    val id: Int,
    val name: String,
    val image: String
)

data class IngredientAmount(
    val ingredient: Ingredient,
    val amount: Int
)
