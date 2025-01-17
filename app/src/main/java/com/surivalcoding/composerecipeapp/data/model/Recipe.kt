package com.surivalcoding.composerecipeapp.data.model

data class Recipe(
    val chef: String = "By Chef",
    val title: String = "Title",
    val cookingDuration: Int = 0,
    val starRate: Double = 0.0,
    val thumbnailUrl: String = "",
) {
    val id: Int = 0
    val procedure: String = ""
    val ingredients: String = ""
    val editedAt: String = ""
    val createdAy: String = ""
    val category: String = ""
    val savedCount: String = ""
    val serving: String = ""
    val videoUrl: String = ""
    val shareUrl: String = ""
}