package com.surivalcoding.composerecipeapp.data.repository.impl

import com.surivalcoding.composerecipeapp.data.data_source.BookmarkDatasource
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDataSource: BookmarkDatasource
) : BookmarkRepository {

    override suspend fun getBookmarkedRecipeIds(): Set<Int> {
        return bookmarkDataSource.getBookmarkedRecipeIds()
    }

    override suspend fun addBookmark(recipeId: Int) = bookmarkDataSource.addBookmark(recipeId)
    override suspend fun removeBookmark(recipeId: Int) = bookmarkDataSource.removeBookmark(recipeId)
    override suspend fun isBookmarked(recipeId: Int) = bookmarkDataSource.isBookmarked(recipeId)
}