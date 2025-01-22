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
import com.surivalcoding.composerecipeapp.data.datasource.UserDataRepository
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.usecase.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.util.Result
import com.surivalcoding.composerecipeapp.util.asResult
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SavedRecipeViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val userDataRepository: UserDataRepository,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

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
                    (application as AppApplication).getSavedRecipesUseCase,
                    application.userDataRepository,
                    application.recipeRepository,
                ) as T
            }
        }
    }
}

sealed interface SavedRecipeUiState {
    data class Success(val recipes: List<SavedRecipe>) : SavedRecipeUiState
    data object Error : SavedRecipeUiState
    data object Loading : SavedRecipeUiState
}