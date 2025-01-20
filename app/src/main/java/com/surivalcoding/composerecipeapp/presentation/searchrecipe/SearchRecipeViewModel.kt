package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.util.AppApplication
import com.surivalcoding.composerecipeapp.util.ResponseResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchRecipeViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _searchRecipeState = MutableStateFlow(SearchRecipesState())
    val searchRecipeState = _searchRecipeState.asStateFlow()

    private var originalRecipeList: List<Recipe> = emptyList() // 원본 리스트 저장


    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            when (val result = recipeRepository.getRecipeList()) {
                is ResponseResult.Success -> {
                    Log.d("RecipeViewModel", "getRecipeList: ${result.data}")
                    originalRecipeList = result.data
                    _searchRecipeState.update { it.copy(recipeList = result.data) }
                }

                is ResponseResult.Failure -> {
                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
                    _searchRecipeState.update { it.copy(recipeList = emptyList()) }
                }
            }
        }
    }

    fun filterRecipeList(value: String) {

        val filteredList = if (value.isBlank()) {
            originalRecipeList
        } else {
            originalRecipeList.filter { it.name.contains(value, ignoreCase = true) }
        }
        _searchRecipeState.update { it.copy(recipeList = filteredList) }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val recipeRepository = (this[APPLICATION_KEY] as AppApplication).recipeRepository
                SearchRecipeViewModel(
                    recipeRepository = recipeRepository
                )
            }
        }
    }
}


