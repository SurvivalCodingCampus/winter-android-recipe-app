package com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model

import Recipe
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.recipe.RecipeRepository
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class RecipeSearchState(
    val keyword: String = "",
    val recipeList: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
)


class RecipeSearchViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(RecipeSearchState())
    val state = _state.asStateFlow()

    init {
        getSearchRecipes()
    }

    fun searchRecipes(newKeyword: String) {
        if (newKeyword.isEmpty()) {
            _state.update {
                it.copy(
                    isLoading = false
                )
            }
        } else {
            _state.update {
                it.copy(
                    keyword = newKeyword
                )
            }
            getSearchRecipes()
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }

        }
    }

    private fun getSearchRecipes() {
        val keyword = _state.value.keyword

        viewModelScope.launch {
            when (val result = recipeRepository.getSearchRecipes(keyword = keyword)) {
                is RResult.Success -> {
                    _state.update {
                        it.copy(
                            recipeList = result.data
                        )
                    }
                }

                is RResult.Error -> {
                    emptyList<Recipe>()
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

                return RecipeSearchViewModel(
                    application.recipeRepository,
                ) as T
            }
        }
    }
}
