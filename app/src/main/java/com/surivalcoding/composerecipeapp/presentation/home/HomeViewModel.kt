package com.surivalcoding.composerecipeapp.presentation.home

import Recipe
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.recipe.RecipeRepository
import com.surivalcoding.composerecipeapp.navigation.Route
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState(
        isSelected = Route.Splash,
        recipeList = emptyList(),
        filteredRecipeList = emptyList(),
    ))
    val state = _state.asStateFlow()




    init {
        viewModelScope.launch {
            searchRecipes("")
        }
    }

    fun selectRoute(route: Route) {
        println(route)
        _state.update {
            it.copy(
                isSelected = route
            )
        }
    }

    fun onSearching(isSearching: Boolean) {
        _state.update {
            it.copy(
                isSearching = isSearching
            )
        }
    }

    fun searchRecipes(newKeyword: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    keyword = newKeyword,
                    isLoading = true
                )
            }
            getSearchRecipes(newKeyword)
        }
    }

    private suspend fun getSearchRecipes(newKeyword: String) {
        when (val result = recipeRepository.getSearchRecipes(keyword = newKeyword)) {
            is RResult.Success -> {
                _state.update {
                    it.copy(
                        recipeList = result.data,
                        isLoading = false
                    )
                }
            }
            is RResult.Error -> {
                emptyList<Recipe>()
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

                return HomeViewModel(
                    application.recipeRepository,
                ) as T
            }
        }
    }
}
