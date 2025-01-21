package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import Recipe
import androidx.lifecycle.SavedStateHandle
import com.surivalcoding.composerecipeapp.data.recipe.RecipeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch




class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(SavedRecipesState())
    val state = _state.asStateFlow()


    init {
        getRecipes()
    }


    private fun getRecipes() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            when (val result = recipeRepository.getSavedRecipes()) {
                is RResult.Success -> {
                    _state.update {
                        it.copy(
                            recipes = result.data,
                            isLoading = false
                        )
                    }
                }

                is RResult.Error -> {
                    _state.update {
                        it.copy(
                            recipes = emptyList()
                        )
                    }
                }
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
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY] as AppApplication)
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return RecipeViewModel(
                    application.recipeRepository,
                    savedStateHandle
                ) as T
            }
        }
    }
}
