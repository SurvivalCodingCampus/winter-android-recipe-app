package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.database.RecipeDao
import com.surivalcoding.composerecipeapp.data.database.RecipeEntity
import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedRecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao
) : SavedRecipeRepository {
    override fun getRecipeList(): Flow<List<RecipeEntity>> {
        return recipeDao.getAllRecipes()
    }

    override fun getAllBookMarkList(): Flow<List<RecipeEntity>> {
        return recipeDao.getBookmarkedRecipes()
    }

    override suspend fun deleteBookmark(id: Int) = recipeDao.removeBookmark(id)

    override suspend fun addBookmark(id: Int) {
        return recipeDao.addBookmark(id)
    }

    override suspend fun saveRecipeList(recipeList: List<RecipeEntity>) {
        // 기존 북마크된 레시피 ID 목록 가져오기
        val bookmarkedRecipeIds = recipeDao.getBookmarkedRecipeIds()

        // 새로운 레시피 리스트
        val updatedRecipeList = recipeList.map { recipe ->

            // 북마크된 레시피 ID 목록에 포함되어 있는지 확인
            if (bookmarkedRecipeIds.contains(recipe.id)) {
                // 북마크 상태 유지
                recipe.copy(isBookMarked = 1)
            } else {
                recipe
            }
        }
        recipeDao.insertRecipes(updatedRecipeList)
    }
}