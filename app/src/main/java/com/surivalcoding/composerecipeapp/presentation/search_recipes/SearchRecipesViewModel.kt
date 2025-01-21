package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchRecipesViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _state = MutableStateFlow(SearchRecipesState())
    val state = _state.asStateFlow()

    init {
        fetchAllRecipes()
    }

    fun fetchRecipes(query: String) {
        if (query.isEmpty()) {
            _state.update {
                it.copy(
                    query = query,
                    filteredRecipes = it.recipes,
                    resultTitle = "Recent Search",
                    resultCount = ""
                )
            }
            return
        }

        // query가 있는 경우 필터링
        val filteredRecipes = state.value.recipes.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.chef.contains(query, ignoreCase = true)
        }

        _state.update {
            it.copy(
                query = query,
                filteredRecipes = filteredRecipes,
                resultTitle = "Search Result",
                resultCount = "${filteredRecipes.size} results"
            )
        }
    }

    private fun fetchAllRecipes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val recipes = recipeRepository.getSavedRecipes()
                _state.update {
                    it.copy(
                        recipes = recipes,
                        filteredRecipes = recipes,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
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
                val application = checkNotNull(extras[APPLICATION_KEY])
                val savedStateHandle = extras.createSavedStateHandle()

                return SearchRecipesViewModel(
                    (application as AppApplication).recipeRepository
                ) as T
            }
        }
    }
}