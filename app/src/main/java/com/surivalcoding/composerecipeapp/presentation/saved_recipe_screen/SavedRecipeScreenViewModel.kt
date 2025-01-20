package com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedRecipeScreenViewModel(
    private val savedRecipeRepository: RecipeRepository,
): ViewModel() {
    private val _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    val savedRecipes = _savedRecipes.asStateFlow()

    init {
        addRecipe()
    }

    private fun addRecipe() {
        viewModelScope.launch {
            _savedRecipes.emit(savedRecipeRepository.getRecipes())
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
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return SavedRecipeScreenViewModel(
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}