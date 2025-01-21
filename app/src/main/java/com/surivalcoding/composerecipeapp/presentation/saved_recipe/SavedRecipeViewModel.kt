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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedRecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _state = MutableStateFlow(SavedRecipeState())
    val state = _state.asStateFlow()  // UI에서 관찰할 수 있도록 public StateFlow 노출

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val recipes = recipeRepository.getSavedRecipes()
                // 데이터 로드 완료 및 로딩 상태 해제
                _state.update {
                    it.copy(
                        recipes = recipes,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                // 에러 처리
                _state.update { it.copy(isLoading = false) }
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