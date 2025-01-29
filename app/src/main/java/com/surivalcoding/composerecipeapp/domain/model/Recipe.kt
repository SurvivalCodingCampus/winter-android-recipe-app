package com.surivalcoding.composerecipeapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Double,
    val isBookMarked: Boolean,
    val ingredients: List<Ingredient>
)

@Serializable
data class Ingredient(
    val ingredient: IngredientDetail,
    val amount: Int
)

@Serializable
data class IngredientDetail(
    val id: Int,
    val name: String,
    val image: String
)