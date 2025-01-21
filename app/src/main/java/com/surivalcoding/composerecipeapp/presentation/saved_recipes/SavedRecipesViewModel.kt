package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedRecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    //private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    //val recipes = _recipes.asStateFlow()

    private val _state = MutableStateFlow(SavedRecipesState())
    val state = _state.asStateFlow()

    init {
        fetchSavedRecipes()
    }

    private fun fetchSavedRecipes() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            delay(2000)
            //_recipes.emit(recipeRepository.getRecipeList())
            val recipes = recipeRepository.getRecipeList()
            _state.update {
                it.copy(recipes = recipes, isLoading = false)
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
                val application = checkNotNull(extras[APPLICATION_KEY])

                return SavedRecipeViewModel(
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}