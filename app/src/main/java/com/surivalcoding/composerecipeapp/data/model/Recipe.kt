package com.surivalcoding.composerecipeapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val title: String,
    val cookingMinute: Int,
    val postTime: String,
    val category: RecipeCategory,
    val thumbnailUrl: String,
    val foodIconUrl: String,
    val rating: Double,
    val authorName: String,
    val ingredients: List<Ingredient>,
    val videoLink: String,
)