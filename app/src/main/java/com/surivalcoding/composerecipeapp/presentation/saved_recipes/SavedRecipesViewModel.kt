package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.RemoveFromSavedRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedRecipesViewModel @Inject constructor(
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

}