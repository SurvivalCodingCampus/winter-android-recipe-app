package com.surivalcoding.composerecipeapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.data.model.HomeRecipe
import com.surivalcoding.composerecipeapp.data.model.NewRecipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepository
import com.surivalcoding.composerecipeapp.presentation.home.HomeUiAction.UpdateCategory
import com.surivalcoding.composerecipeapp.presentation.home.HomeUiAction.UpdateUserBookMarked
import com.surivalcoding.composerecipeapp.util.Result
import com.surivalcoding.composerecipeapp.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    recipeRepository: RecipeRepository,
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    private var _selectedCategory = MutableStateFlow(RecipeCategory.ALL)
    val homeUiState: StateFlow<HomeUiState> = homeUiState(
        _selectedCategory,
        userDataRepository,
        recipeRepository
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = HomeUiState.Loading
        )

    fun onAction(action: HomeUiAction) {
        when (action) {
            is UpdateCategory -> _selectedCategory.update { action.category }
            is UpdateUserBookMarked -> {
                userDataRepository.setRecipeBookmarked(action.id, action.bookmarked)
            }
        }
    }
}

private fun homeUiState(
    selectedCategory: StateFlow<RecipeCategory>,
    userDataRepository: UserDataRepository,
    recipeRepository: RecipeRepository,
): Flow<HomeUiState> {
    val bookmarkedIds = userDataRepository.userData.map { it.bookmarkIds }
    return combine(
        selectedCategory,
        bookmarkedIds,
        recipeRepository.getHomeRecipes(selectedCategory.value),
        recipeRepository.getNewRecipes(),
        HomeUiState::Loaded
    )
        .asResult()
        .map { homeUiResult ->
            when (homeUiResult) {
                is Result.Success -> {
                    HomeUiState.Loaded(
                        selectedCategory = homeUiResult.data.selectedCategory,
                        bookmarkedIds = homeUiResult.data.bookmarkedIds,
                        homeRecipes = homeUiResult.data.homeRecipes,
                        newRecipes = homeUiResult.data.newRecipes
                    )
                }

                is Result.Error -> HomeUiState.Error
                is Result.Loading -> HomeUiState.Loading
            }
        }
}

sealed interface HomeUiState {
    data object Error : HomeUiState
    data object Loading : HomeUiState
    data class Loaded(
        val selectedCategory: RecipeCategory = RecipeCategory.ALL,
        val bookmarkedIds: List<Int>,
        val homeRecipes: List<HomeRecipe>,
        val newRecipes: List<NewRecipe>,
    ) : HomeUiState
}

sealed interface HomeUiAction {
    data class UpdateCategory(val category: RecipeCategory) : HomeUiAction
    data class UpdateUserBookMarked(val id: Int, val bookmarked: Boolean) : HomeUiAction
}