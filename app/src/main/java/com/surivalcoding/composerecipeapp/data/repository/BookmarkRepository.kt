package com.surivalcoding.composerecipeapp.data.repository

interface BookmarkRepository {
    suspend fun getBookmarkId(): List<Int>

    suspend fun cancelBookmarkId(id: Int = 0) : List<Int>
}