package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.common.result.Result
import com.surivalcoding.composerecipeapp.common.result.asResult
import com.surivalcoding.composerecipeapp.data.mapper.toSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.data.model.SearchFilterOptions
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userDataRepository: UserDataRepository,
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")

    private val _actions = MutableSharedFlow<SearchRecipeAction>()
    private val actions = _actions.asSharedFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchRecipeUiState: StateFlow<SearchRecipeUiState> = searchRecipeUiState(
        searchQuery = searchQuery,
        userDataRepository = userDataRepository,
        recipeRepository = recipeRepository,
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SearchRecipeUiState.Loading
        )

    init {
        viewModelScope.launch {
            actions.collect {
                handleAction(it)
            }
        }
    }

    fun setAction(action: SearchRecipeAction) {
        viewModelScope.launch {
            _actions.emit(action)
        }
    }

    fun handleAction(action: SearchRecipeAction) {
        when (action) {
            is SearchRecipeAction.SearchQueryChanged -> {
                savedStateHandle[SEARCH_QUERY] = action.query
                userDataRepository.setRecentQuery(action.query)
            }

            is SearchRecipeAction.FilterOptionsChanged -> {
                userDataRepository.setSearchFilterOptions(action.options)
            }
        }
    }
}

fun searchRecipeUiState(
    searchQuery: StateFlow<String>,
    recipeRepository: RecipeRepository,
    userDataRepository: UserDataRepository,
): Flow<SearchRecipeUiState> {
    return combine(
        searchQuery,
        userDataRepository.userData,
        recipeRepository.getRecipes(),
        ::Triple
    )
        .asResult()
        .map { searchRecipeUiResult ->
            when (searchRecipeUiResult) {
                is Result.Error -> SearchRecipeUiState.LoadFailed
                Result.Loading -> SearchRecipeUiState.Loading
                is Result.Success -> {
                    val (query, userData, recipes) = searchRecipeUiResult.data
                    val (_, rating, category) = userData.searchFilterOptions
                    val filteredRecipes = recipes.filter {
                        (category == RecipeCategory.ALL || it.category == category) &&
                                it.rating.roundToInt() == rating
                    }.map { it.toSearchRecipe() }
                    if (query.trim().length < SEARCH_QUERY_MIN_LENGTH) {
                        SearchRecipeUiState.RecentRecipeLoaded(
                            query = userData.recentQuery,
                            filterOptions = userData.searchFilterOptions,
                            recipes = filteredRecipes.filter { userData.recentQuery in it.title }
                        )
                    } else {
                        SearchRecipeUiState.SearchRecipeLoaded(
                            query = query,
                            filterOptions = userData.searchFilterOptions,
                            recipes = filteredRecipes.filter { query in it.title }
                        )
                    }
                }
            }
        }
}

sealed interface SearchRecipeUiState {
    data object Loading : SearchRecipeUiState
    data object LoadFailed : SearchRecipeUiState
    sealed class Loaded(
        open val query: String,
        open val filterOptions: SearchFilterOptions,
        open val recipes: List<SearchRecipe>
    ) : SearchRecipeUiState {
        fun isEmpty(): Boolean = recipes.isEmpty()
    }

    data class RecentRecipeLoaded(
        override val query: String,
        override val filterOptions: SearchFilterOptions,
        override val recipes: List<SearchRecipe>
    ) : Loaded(query, filterOptions, recipes)

    data class SearchRecipeLoaded(
        override val query: String,
        override val filterOptions: SearchFilterOptions,
        override val recipes: List<SearchRecipe>
    ) : Loaded(query, filterOptions, recipes)
}

sealed interface SearchRecipeAction {
    data class SearchQueryChanged(val query: String) : SearchRecipeAction
    data class FilterOptionsChanged(val options: SearchFilterOptions) : SearchRecipeAction
}

private const val SEARCH_QUERY = "searchQuery"
private const val SEARCH_QUERY_MIN_LENGTH = 2