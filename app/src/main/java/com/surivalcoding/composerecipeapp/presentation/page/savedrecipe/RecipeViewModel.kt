package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.util.AppApplication
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class RecipeViewModel @Inject constructor(
//    private val recipeRepository: RecipeRepository
//) : ViewModel() {
//
//    private val _recipeList = MutableStateFlow<List<Recipe>>(emptyList())
//    val recipeList = _recipeList.asStateFlow()
//
//    private val _loadingState = MutableStateFlow(LoadingState())
//    val loadingState = _loadingState.asStateFlow()
//
//    init {
//        getRecipeList()
//    }
//
//    private fun getRecipeList() {
//        _loadingState.update { it.copy(isLoading = true) }
//        viewModelScope.launch {
//            when (val result = recipeRepository.getRecipeList()) {
//                is ResponseResult.Success -> {
//                    Log.d("RecipeViewModel", "getRecipeList: ${result.data}")
//                    _recipeList.emit(result.data)
//                }
//
//                is ResponseResult.Failure -> {
//                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
//                    _recipeList.emit(emptyList())
//                }
//            }
//            _loadingState.update { it.copy(isLoading = false) }
//        }
//    }
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val recipeRepository = (this[APPLICATION_KEY] as AppApplication).recipeRepository
//                RecipeViewModel(
//                    recipeRepository = recipeRepository
//                )
//            }
//        }
//    }
//}