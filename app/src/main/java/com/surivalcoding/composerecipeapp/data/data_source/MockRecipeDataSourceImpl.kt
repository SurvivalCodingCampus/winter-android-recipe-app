package com.surivalcoding.composerecipeapp.data.data_source

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockRecipeDataSourceImpl: RecipeDataSource {
    override suspend fun getRecipeList(): List<RecipeDto> = withContext(Dispatchers.IO) {
        buildList {
            repeat(10) {
                Recipe(
                    id = "1",
                    name = "JMT Egg",
                    authorName = "Rami",
                    timeTaken = 10,
                    rate = 5.0f,
                    circledThumbnailImageUrl = "",
                    thumbnailImageUrl = "https://png.pngtree.com/png-vector/20231016/ourlarge/pngtree-breakfast-fried-egg-png-image_10198332.png",
                    isUserSaved = false,
                    isUserReviewed = false,
                    isUserRated = true,
                    isNew = false,
                    categories = listOf("Italian", "Pasta"),
                    createdAt = "2023-10-16T12:00:00"
                )
            }
        }
    }

}