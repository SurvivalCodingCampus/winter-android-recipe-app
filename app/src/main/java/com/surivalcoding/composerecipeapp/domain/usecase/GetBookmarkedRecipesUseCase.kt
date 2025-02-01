package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.data.repository.SavedRecipeRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// 전체 북마크 리스트 가져오기
class GetBookmarkedRecipesUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    fun execute(): Flow<ResponseResult<List<Recipe>>> {
        return savedRecipeRepository.getAllBookMarkList()
            .map { recipeList ->
                ResponseResult.Success(recipeList.map { it.toMapper() })
            }
            .catch { e ->
                ResponseResult.Failure(e)
            }
    }
}
