package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.domain.savedscreen.GetSavedRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchRecipeViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
) : ViewModel() {
//    private val _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
//    val savedRecipes = _savedRecipes.asStateFlow()

    private val _state: MutableStateFlow<SearchRecipeState> = MutableStateFlow(SearchRecipeState())
    val state = _state.asStateFlow()

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            _state.emit(
                SearchRecipeState(
                    recipes = getSavedRecipesUseCase.execute()
                )
            )
        }
    }

    // 검색 결과 리스트
    private var recipes = MutableStateFlow(listOf<Recipe>())
    private var screenText = MutableStateFlow<String>("Recent Search")
    private var isSearching = MutableStateFlow<Boolean>(false)

    // 검색어 변경 처리
    fun onSearchQueryChanged(newQuery: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    query = newQuery,
                    searchScreenText = "Search Result",
                    isSearching = isSearching.value,
                )
            }

            val allRecipes = getSavedRecipesUseCase.execute()

            performSearch(newQuery, allRecipes)

            _state.update {
                it.copy(
                    recipes = recipes.value,
                    searchScreenText = screenText.value,
                    searchResultCount = recipes.value.size,
                    isSearching = isSearching.value
                )
            }
        }
    }

    // 검색 수행 로직
    private fun performSearch(query: String, allRecipes: List<Recipe>) {
        if (query.isEmpty()) {
            recipes.value = allRecipes
            screenText.value = "Recent Search"
            isSearching.value = false
        } else {
            recipes.value = allRecipes.filter { it.title.contains(query, ignoreCase = true) }
            screenText.value = "Search Result"
            isSearching.value = true
        }
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val recipes = getSavedRecipesUseCase.execute()

            _state.update {
                it.copy(
                    isLoading = false,
                    recipes = recipes
                )
            }
        }
    }

    fun waitSearchRecipes() {
        viewModelScope.launch {
            // 로딩 시작
            _state.update { it.copy(isLoading = true) }

            // Repository에서 데이터를 가져오기
            val recipes = getSavedRecipesUseCase.execute()

            // 로딩 종료 및 상태 업데이트
            _state.update {
                it.copy(
                    isLoading = false,
                    recipes = recipes
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

                return SearchRecipeViewModel(
                    (application as AppApplication).getSavedRecipesUseCase,
                ) as T
            }
        }
    }
}