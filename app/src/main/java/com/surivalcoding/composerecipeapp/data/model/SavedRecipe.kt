package com.surivalcoding.composerecipeapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SavedRecipe(
    val thumbnailUrl: String,
    val cookingMinute: Int,
    val title: String,
    val authorName: String,
    val rating: Double,
    val isBookmarked: Boolean,
)
