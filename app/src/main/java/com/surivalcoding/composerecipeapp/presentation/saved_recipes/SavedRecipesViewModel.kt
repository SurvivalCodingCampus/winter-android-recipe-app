package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.RemoveFromSavedRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedRecipesViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val removeFromSavedRecipesUseCase: RemoveFromSavedRecipesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SavedRecipesState())
    val state: StateFlow<SavedRecipesState> = _state.asStateFlow()

    init {
        loadSavedRecipes()
    }

    private fun loadSavedRecipes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val recipes = getSavedRecipesUseCase.execute()
                _state.update {
                    it.copy(
                        recipes = recipes,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                println("Error: ${e.message}")
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    fun onBookmarkClick(recipeId: Int) {
        viewModelScope.launch {
            try {
                removeFromSavedRecipesUseCase.execute(recipeId)
                loadSavedRecipes()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY]) as AppApplication

                return SavedRecipesViewModel(
                    getSavedRecipesUseCase = application.getSavedRecipesUseCase,
                    removeFromSavedRecipesUseCase = application.removeFromSavedRecipesUseCase
                ) as T
            }
        }
    }
}