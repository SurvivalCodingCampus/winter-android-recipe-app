package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.model.Recipe
import org.example.day19.model.RecipeDetail
import org.example.day19.repository.RecipeRepository

class RecipeRepositoryImpl(private val dataSource: RecipeDataSource): RecipeRepository {
    override suspend fun searchRecipes(
        keyword: String,
        timeTaken: Int?,
        rate: Int?,
        categories: List<String>
    ): List<Recipe> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeDetail(recipeId: String): RecipeDetail {
        TODO("Not yet implemented")
    }

    override suspend fun saveRecipe(recipeId: String, isUserSaved: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedRecipes(): List<Recipe> {
        // DataSource에서 RecipeDto 리스트를 가져와 도메인 모델로 변환
        return dataSource.getRecipeList().map { dto ->
            Recipe(
                id = dto.id ?: "",
                name = dto.name ?: "Unknown",
                authorName = dto.authorName ?: "Anonymous",
                timeTaken = dto.timeTaken ?: 0,
                rate = dto.rate ?: 0f,
                circledThumbnailImageUrl = dto.circledThumbnailImageUrl ?: "",
                thumbnailImageUrl = dto.thumbnailImageUrl ?: "",
                isUserSaved = dto.isUserSaved ?: false,
                isUserReviewed = dto.isUserReviewed ?: false,
                isUserRated = dto.isUserRated ?: false,
                isNew = dto.isNew ?: false,
                categories = dto.categories ?: emptyList(),
                createdAt = dto.createdAt ?: ""
            )
        }
    }

    override suspend fun rateRecipe(
        userId: String,
        recipeId: String,
        rating: Int,
        isUserRated: Boolean
    ) {
        TODO("Not yet implemented")
    }
}
