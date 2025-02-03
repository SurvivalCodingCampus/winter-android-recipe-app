package com.surivalcoding.composerecipeapp.domain.repository

interface BookmarkRepository {
    suspend fun getBookmarkedRecipeIds(): Set<Int>
    suspend fun addBookmark(recipeId: Int)
    suspend fun removeBookmark(recipeId: Int)
    suspend fun isBookmarked(recipeId: Int): Boolean
}