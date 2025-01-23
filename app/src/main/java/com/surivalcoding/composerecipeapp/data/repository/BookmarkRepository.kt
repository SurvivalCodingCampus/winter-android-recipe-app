package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe

interface BookmarkRepository {
    suspend fun getBookMarkList(): List<Recipe>
    suspend fun deleteBookmark(id: Int): List<Recipe>
}