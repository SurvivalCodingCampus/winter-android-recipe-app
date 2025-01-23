package com.surivalcoding.composerecipeapp.data.model

import androidx.annotation.DrawableRes

class NewRecipe(
    val id: Int,
    @DrawableRes
    val foodIconUrl: Int,
    val cookingMinute: Int,
    val title: String,
    val rating: Double,
    val authorName: String,
    @DrawableRes
    val authorAvatarUrl: Int,
)