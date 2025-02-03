package com.surivalcoding.composerecipeapp.data.data_source.local

import com.surivalcoding.composerecipeapp.data.data_source.BookmarkDatasource

class MockBookmarkDatasource : BookmarkDatasource {
    private val bookmarkedRecipeIds = mutableSetOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    override suspend fun getBookmarkedRecipeIds(): Set<Int> {
        return bookmarkedRecipeIds.toSet()
    }

    override suspend fun addBookmark(recipeId: Int) {
        bookmarkedRecipeIds.add(recipeId)
    }

    override suspend fun removeBookmark(recipeId: Int) {
        bookmarkedRecipeIds.remove(recipeId)
    }

    override suspend fun isBookmarked(recipeId: Int) = bookmarkedRecipeIds.contains(recipeId)

}