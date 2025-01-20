package com.surivalcoding.composerecipeapp.data.recipe

import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientModel

data class RecipeModel(
    val id: String,
    val title: String,
    val procedure: List<String>,
    val ingredients: List<IngredientModel>,
    val category: String,
    val cookingDuration: Int,  // minutes
    val serving: Int,
    val thumbnailUrl: String? = null,
    val videoUrl: String? = null,
    val shareUrl: String? = null,
    val starRate: Float = 0f,
    val savedCount: Int = 0,
    val createdBy: String,  // User ID
    val createdAt: Long,
    val editedAt: Long? = null
)
