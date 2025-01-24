package com.surivalcoding.composerecipeapp.domain.usecase.recipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class GetSavedRecipesUseCase(
    private val bookmarkRepository: BookmarkRepository,
    private val recipeRepository: RecipeRepository
) {

    // 북마크된 레시피 목록 가져오기
    suspend fun execute(): List<Recipe> {
        // 1. 북마크된 레시피의 ID 목록을 가져오기
        val bookmarkedRecipeIds = bookmarkRepository.getBookmarkedRecipeIds()

        // 2. 모든 레시피 목록을 가져오기
        val allRecipes = recipeRepository.getAllRecipes()

        // 3. 북마크된 ID에 해당하는 레시피만 필터링하여 반환
        return allRecipes.filter { recipe -> bookmarkedRecipeIds.contains(recipe.id) }
    }
}
