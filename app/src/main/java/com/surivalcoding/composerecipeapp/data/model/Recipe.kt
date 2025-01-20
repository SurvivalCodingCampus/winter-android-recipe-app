package com.surivalcoding.composerecipeapp.data.model

data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Double,
    val ingredients: List<Ingredient>
)

data class Ingredient(
    val ingredient: IngredientDetail,
    val amount: Int
)

data class IngredientDetail(
    val id: Int,
    val name: String,
    val image: String
)