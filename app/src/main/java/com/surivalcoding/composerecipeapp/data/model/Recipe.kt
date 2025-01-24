package com.surivalcoding.composerecipeapp.data.model

import com.surivalcoding.composerecipeapp.data.mock.fakeAvatarImage
import com.surivalcoding.composerecipeapp.data.mock.fakeImageDrawables
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

fun Recipe.toSavedRecipe() = SavedRecipe(
    id = id,
    thumbnailUrl = thumbnailUrl,
    cookingMinute = cookingMinute,
    title = title,
    authorName = authorName,
    rating = rating,
)

fun Recipe.toHomeRecipe() = HomeRecipe(
    id = id,
    foodIconUrl = fakeImageDrawables[(id - 1) % 3],
    cookingMinute = cookingMinute,
    title = title,
    rating = rating,
)

fun Recipe.toNewRecipe() = NewRecipe(
    id = id,
    foodIconUrl = fakeImageDrawables[(id + 1) % 3],
    cookingMinute = cookingMinute,
    title = title,
    rating = rating,
    authorName = authorName,
    authorAvatarUrl = fakeAvatarImage[(id - 1) % 3],
)