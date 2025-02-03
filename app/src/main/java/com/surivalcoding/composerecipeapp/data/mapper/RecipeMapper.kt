package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.mock.fakeAvatarImage
import com.surivalcoding.composerecipeapp.data.mock.fakeImageDrawables
import com.surivalcoding.composerecipeapp.data.model.HomeRecipe
import com.surivalcoding.composerecipeapp.data.model.NewRecipe
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe

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

fun Recipe.toSearchRecipe() = SearchRecipe(
    thumbnailUrl = thumbnailUrl,
    title = title,
    rating = rating,
    authorName = authorName
)