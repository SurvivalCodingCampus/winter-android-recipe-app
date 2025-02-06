package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.SearchRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipesViewModel @Inject constructor (private val searchRecipeUseCase: SearchRecipeUseCase) : ViewModel() {
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
                val recipes = searchRecipeUseCase.execute()
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

}