package com.surivalcoding.composerecipeapp.data.data_source


interface BookmarkDatasource {
    suspend fun getBookmarkedRecipeIds(): Set<Int>
    suspend fun addBookmark(recipeId: Int)
    suspend fun removeBookmark(recipeId: Int)
    suspend fun isBookmarked(recipeId: Int): Boolean
}