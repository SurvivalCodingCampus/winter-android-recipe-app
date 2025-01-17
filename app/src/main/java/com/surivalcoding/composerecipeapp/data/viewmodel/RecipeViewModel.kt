package com.surivalcoding.composerecipeapp.data.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.util.AppApplication
import com.surivalcoding.composerecipeapp.util.ResponseResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeRepository: RecipeRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _recipeList = MutableStateFlow<List<Recipe>>(emptyList())
    val recipeList = _recipeList.asStateFlow()

    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        viewModelScope.launch {
            when (val result = recipeRepository.getRecipeList()) {
                is ResponseResult.Success -> {
                    Log.d("RecipeViewModel", "getRecipeList: ${result.data}")
                    _recipeList.emit(result.data)
                }

                is ResponseResult.Failure -> {
                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
                    _recipeList.emit(emptyList())
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val recipeRepository = (this[APPLICATION_KEY] as AppApplication).recipeRepository
                RecipeViewModel(
                    recipeRepository = recipeRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
}