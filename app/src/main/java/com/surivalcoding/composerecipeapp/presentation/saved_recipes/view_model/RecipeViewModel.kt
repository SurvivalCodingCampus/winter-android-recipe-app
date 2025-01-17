package com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model

import Recipe
import RecipeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    private val _recipesList = MutableStateFlow<List<Recipe>>(emptyList())
    val recipeList = _recipesList.asStateFlow()

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            val result = recipeRepository.getSavedRecipes()
            when (result) {
                is RResult.Success -> {
                    _recipesList.emit(result.data)
                }
                is RResult.Error -> {
                    _recipesList.emit(emptyList())
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
//                val savedStateHandle = extras.createSavedStateHandle()

                return RecipeViewModel(
                    application.recipeRepository,
//                    savedStateHandle
                ) as T
            }
        }
    }
}
