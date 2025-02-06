package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.ResponseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {

    fun execute(): Flow<ResponseResult<List<Recipe>>> {
        return savedRecipeRepository.getRecipeList()
            .map { recipeList ->
                ResponseResult.Success(recipeList)
            }
            .catch { e ->
                ResponseResult.Failure(e)
            }
    }
}