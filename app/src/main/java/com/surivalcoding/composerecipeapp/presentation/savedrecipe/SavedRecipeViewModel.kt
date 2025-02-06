package com.surivalcoding.composerecipeapp.presentation.savedrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.common.result.Result
import com.surivalcoding.composerecipeapp.common.result.asResult
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepository
import com.surivalcoding.composerecipeapp.data.usecase.GetSavedRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SavedRecipeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userDataRepository: UserDataRepository,
    getSavedRecipesUseCase: GetSavedRecipesUseCase,
) : ViewModel() {

    // val recipeUiState: SavedRecipeUiState = SavedRecipeUiState.Loading
    val recipeUiState: StateFlow<SavedRecipeUiState> = getSavedRecipesUseCase()
        .asResult()
        .map { savedRecipesResult ->
            when (savedRecipesResult) {
                is Result.Success -> SavedRecipeUiState.Success(savedRecipesResult.data)
                is Result.Loading -> SavedRecipeUiState.Loading
                is Result.Error -> SavedRecipeUiState.Error
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SavedRecipeUiState.Loading
        )

    fun setSavedRecipeBookmarked(recipeId: Int) {
        userDataRepository.setRecipeBookmarked(recipeId, false)
    }
}

sealed interface SavedRecipeUiState {
    data class Success(val recipes: List<SavedRecipe>) : SavedRecipeUiState
    data object Error : SavedRecipeUiState
    data object Loading : SavedRecipeUiState
}