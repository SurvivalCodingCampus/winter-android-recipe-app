package org.example.day19.model


data class RecipeDetail(
    val author: Author,
    val serve: Int,
    val ingredients: List<Ingredient>,
    val steps: List<Step>,
)