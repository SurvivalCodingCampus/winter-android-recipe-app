package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.LoadingState
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _searchRecipeState = MutableStateFlow(SearchRecipesState())
    val searchRecipeState = _searchRecipeState.asStateFlow()

    private val _loadingState = MutableStateFlow(LoadingState())
    val loadingState = _loadingState.asStateFlow()


    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        _loadingState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            when (val result = recipeRepository.getRecipeList()) {
                is ResponseResult.Success -> {
                    Log.d("RecipeViewModel", "getRecipeList: ${result.data}")
                    _searchRecipeState.update {
                        it.copy(
                            recipeList = result.data,
                            filteredRecipeList = result.data
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
                    _searchRecipeState.update { it.copy(recipeList = emptyList()) }
                }
            }
            _loadingState.update { it.copy(isLoading = false) }
        }
    }

    fun filterRecipeList(value: String) {

        val filteredList = if (value.isBlank()) {
            _searchRecipeState.value.recipeList
        } else {
            _searchRecipeState.value.recipeList.filter { it.name.contains(value, ignoreCase = true) }
        }
        _searchRecipeState.update { it.copy(filteredRecipeList = filteredList) }
    }
}


