package com.surivalcoding.composerecipeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.domain.usecase.GetRecipesUseCase
import com.surivalcoding.composerecipeapp.ui.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipesViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            val recipes = getRecipesUseCase()
            _searchState.update {
                it.copy(
                    recipes = recipes,
                    filteredRecipes = recipes
                )
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchState.update {
            it.copy(
                query = query,
                filteredRecipes = it.recipes.filter { recipe ->
                    recipe.title.contains(query, ignoreCase = true)
                }
            )
        }
    }
}