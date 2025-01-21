package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.datasource.RecentSearchRecipeRepository
import com.surivalcoding.composerecipeapp.data.datasource.RecipeRepository
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SearchRecipeViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val recentSearchRecipeRepository: RecentSearchRecipeRepository,
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchRecipeUiState: StateFlow<SearchRecipeUiState> =
        searchQuery.flatMapLatest { query ->
            if (query.trim().length < SEARCH_QUERY_MIN_LENGTH) {
                recentSearchRecipeRepository
                    .getRecentSearchRecipe()
                    .map { recentRecipes ->
                        SearchRecipeUiState.Success(recentRecipes)
                    }
                    .catch {
                        SearchRecipeUiState.LoadFailed
                    }
            } else {
                recipeRepository
                    .getSearchRecipes(query)
                    .map { data ->
                        SearchRecipeUiState.Success(data)
                    }
                    .catch {
                        SearchRecipeUiState.LoadFailed
                    }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SearchRecipeUiState.Loading
        )

    fun onSearchQueryChanged(query: String) {
        savedStateHandle[SEARCH_QUERY] = query
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

                return SearchRecipeViewModel(
                    savedStateHandle,
                    (application as AppApplication).recentSearchRecipeRepository,
                    application.recipeRepository,
                ) as T
            }
        }
    }
}

sealed interface SearchRecipeUiState {
    data object Loading : SearchRecipeUiState
    data object EmptyQuery : SearchRecipeUiState
    data object LoadFailed : SearchRecipeUiState
    data class Success(
        val recipes: List<SearchRecipe>,
    ) : SearchRecipeUiState {
        fun isEmpty(): Boolean = recipes.isEmpty()
    }
}

private const val SEARCH_QUERY = "searchQuery"
private const val SEARCH_QUERY_MIN_LENGTH = 2