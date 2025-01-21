package com.surivalcoding.composerecipeapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchRecipe(
    val thumbnailUrl: String,
    val title: String,
    val rating: Double,
    val authorName: String,
)