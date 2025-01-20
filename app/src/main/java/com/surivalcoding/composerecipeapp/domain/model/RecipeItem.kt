package com.surivalcoding.composerecipeapp.domain.model

import java.util.UUID

data class RecipeItem(
    val id: String = UUID.randomUUID().toString(),
    val thumbnailUrl: String,
    val cookingMinute: Int,
    val title: String,
    val chefName: String,
    val rating: Double,
    var isBookmarked: Boolean
)