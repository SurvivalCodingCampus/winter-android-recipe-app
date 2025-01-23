package com.surivalcoding.composerecipeapp.data.usecase

import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.toSavedRecipe
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class GetSavedRecipesUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val recipeRepository: RecipeRepository,
) {
    operator fun invoke(): Flow<List<SavedRecipe>> {
        val userBookmarkedIds = userDataRepository.userData.map { it.bookmarkIds }
        val recipesStream = recipeRepository.getRecipes()

        return combine(
            userBookmarkedIds,
            recipesStream,
            ::Pair
        ).map { (ids, recipes) ->
            recipes.filter { it.id in ids }.map { it.toSavedRecipe() }
        }
    }
}