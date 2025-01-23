package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import com.surivalcoding.composerecipeapp.data.repository.RecentSearchRecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recentSearchRecipeRepository: RecentSearchRecipeRepository,
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchRecipeUiState: StateFlow<SearchRecipeUiState> =
        searchQuery.flatMapLatest { query ->
            if (query.trim().length < SEARCH_QUERY_MIN_LENGTH) {
                recentSearchRecipeRepository
                    .getRecentSearchRecipe()
                    .map { recentRecipes ->
                        SearchRecipeUiState.EmptyQuery(recentRecipes)
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
}

sealed interface SearchRecipeUiState {
    data object Loading : SearchRecipeUiState
    data object LoadFailed : SearchRecipeUiState
    data class EmptyQuery(
        val recentRecipes: List<SearchRecipe>,
    ) : SearchRecipeUiState {
        fun isEmpty(): Boolean = recentRecipes.isEmpty()
    }

    data class Success(
        val searchRecipes: List<SearchRecipe>,
    ) : SearchRecipeUiState {
        fun isEmpty(): Boolean = searchRecipes.isEmpty()
    }
}

private const val SEARCH_QUERY = "searchQuery"
private const val SEARCH_QUERY_MIN_LENGTH = 2