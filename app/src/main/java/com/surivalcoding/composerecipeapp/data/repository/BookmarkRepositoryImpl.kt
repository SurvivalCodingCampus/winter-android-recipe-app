package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val recipeDataSource: RecipeDataSource
) : BookmarkRepository {

    private var bookMarkedRecipeList: MutableList<Recipe>? = null

    override suspend fun getBookMarkList(): List<Recipe> = withContext(Dispatchers.IO) {
        delay(1000L)
        if (bookMarkedRecipeList == null) {
            bookMarkedRecipeList = recipeDataSource.getRecipeList()
                .filter { it.isBookMarked == true }
                .map { it.toMapper() }
                .toMutableList()
        }
        return@withContext bookMarkedRecipeList ?: emptyList()
    }

    override suspend fun deleteBookmark(id: Int): List<Recipe> = withContext(Dispatchers.IO) {
        // 리스트가 초기화되지 않았으면 getBookMarkList 호출로 초기화
        val bookmarks = bookMarkedRecipeList
        bookmarks?.removeAll { it.id == id }
        return@withContext bookmarks ?: emptyList()
    }
}