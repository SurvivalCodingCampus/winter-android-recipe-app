package com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.domain.use_case.GetSavedRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedRecipeViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
) : ViewModel() {
//    private val _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
//    val savedRecipes = _savedRecipes.asStateFlow()

    private val _state: MutableStateFlow<SavedRecipeState> = MutableStateFlow(SavedRecipeState())
    val state = _state.asStateFlow()

    init {
        waitSavedRecipes()

//        fetchSavedRecipes()
//        viewModelScope.launch {
//            val recipes = savedRecipeRepository.getRecipes()
//            _savedRecipes.value = recipes

//            _savedRecipes.emit(savedRecipeRepository.getRecipes())
//        }
    }

    fun fetchSavedRecipes(id: Int) {
        viewModelScope.launch {
            val recipes = getSavedRecipesUseCase.execute(id)

            _state.update {
                it.copy(
                    savedRecipes = recipes
                )
            }
        }
    }

    private fun waitSavedRecipes() {
        viewModelScope.launch {
            // 로딩 시작
            _state.update { it.copy(isLoading = true) }

            // Repository에서 데이터를 가져오기
            val recipes = getSavedRecipesUseCase.execute()

            // 로딩 종료 및 상태 업데이트
            _state.update {
                it.copy(
                    isLoading = false,
                    savedRecipes = recipes
                )
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
                    (application as AppApplication).getSavedRecipesUseCase,
                ) as T
            }
        }
    }
}