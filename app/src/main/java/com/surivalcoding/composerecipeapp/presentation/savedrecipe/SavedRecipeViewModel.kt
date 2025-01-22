package com.surivalcoding.composerecipeapp.presentation.savedrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.datasource.RecipeRepository
import com.surivalcoding.composerecipeapp.data.mock.testIds
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.util.Result
import com.surivalcoding.composerecipeapp.util.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SavedRecipeViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    val recipeUiState: StateFlow<SavedRecipeUiState> = savedRecipeUiState(
        ids = testIds,
        recipeRepository = recipeRepository
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SavedRecipeUiState.Loading
    )

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val savedStateHandle = extras.createSavedStateHandle()

                return SavedRecipeViewModel(
                    savedStateHandle,
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}

private fun savedRecipeUiState(
    ids: List<Int>,
    recipeRepository: RecipeRepository
): Flow<SavedRecipeUiState> = recipeRepository.getSavedRecipes(ids)
    .asResult()
    .map { savedRecipesResult ->
        when (savedRecipesResult) {
            is Result.Success -> SavedRecipeUiState.Success(savedRecipesResult.data)
            is Result.Loading -> SavedRecipeUiState.Loading
            is Result.Error -> {
                SavedRecipeUiState.Error(savedRecipesResult.exception)
            }
        }
    }

sealed interface SavedRecipeUiState {
    data class Success(val recipes: List<SavedRecipe>) : SavedRecipeUiState
    data class Error(val e: Throwable) : SavedRecipeUiState
    data object Loading : SavedRecipeUiState
}