package com.surivalcoding.composerecipeapp.presentation.saved_recipe

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

class SavedRecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes = _recipes.asStateFlow()  // UI에서 관찰할 수 있도록 public StateFlow 노출

    init {
        viewModelScope.launch {
            _recipes.emit(recipeRepository.getSavedRecipes())
            // 또는
            // _recipes.value = recipeRepository.getSavedRecipes()
            // 둘 다 가능하지만 suspend 함수의 경우 emit 사용이 더 idiomatic
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

                return SavedRecipeViewModel(
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}