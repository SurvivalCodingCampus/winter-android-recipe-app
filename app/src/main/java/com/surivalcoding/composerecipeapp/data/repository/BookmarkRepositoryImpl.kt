package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.UserDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toUser

class BookmarkRepositoryImpl(private val dataSource: UserDataSource): BookmarkRepository {
    private var bookmarkList = mutableListOf<Int>()

    override suspend fun getBookmarkId(): List<Int> {
        return dataSource.getAllUsers().map { it.toUser() }[0].savedRecipesId
    }

    override suspend fun cancelBookmarkId(id: Int): List<Int> {
        if (id != 0) {
            bookmarkList.add(id)
            return getBookmarkId().filter { it !in bookmarkList }
        } else {
            return getBookmarkId()
        }
    }
}