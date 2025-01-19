package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    val id: String? = null,
    val name: String? = null,
    val authorName: String? = null,
    val timeTaken: Int? = null,
    val rate: Float? = null,
    val circledThumbnailImageUrl: String? = null,
    val thumbnailImageUrl: String? = null,
    val isUserSaved: Boolean? = null,
    val isUserReviewed: Boolean? = null,
    val isUserRated: Boolean? = null,
    val isNew: Boolean? = null,
    val categories: List<String>? = null,
    val createdAt: String? = null
)
