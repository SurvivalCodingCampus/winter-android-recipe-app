package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.database.RecipeEntity
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface SavedRecipeRepository {

    // 전체 북마크 리스트 가져오기
    fun getAllBookMarkList(): Flow<List<RecipeEntity>>

    // 북마크 삭제
    suspend fun deleteBookmark(id: Int)

    // 북마크 추가
    suspend fun addBookmark(id: Int)

    // 전체 레시피 저장
    suspend fun saveRecipeList(recipeList: List<RecipeEntity>)
}