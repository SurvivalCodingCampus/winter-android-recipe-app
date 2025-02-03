package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.GetMainRecipeListUseCase
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.LoadingState
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val getMainRecipeListUseCase: GetMainRecipeListUseCase
) : ViewModel() {

    private val _searchRecipeState = MutableStateFlow(SearchRecipesState())
    val searchRecipeState = _searchRecipeState.asStateFlow()

    init {
        getRecipeList()
    }

    private fun getRecipeList() {
        _searchRecipeState.update {
            it.copy(
                loadingState = LoadingState(isLoading = true)
            )
        }
        viewModelScope.launch {
            when (val result = getMainRecipeListUseCase.execute()) {
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
            _searchRecipeState.update {
                it.copy(loadingState = LoadingState(isLoading = false))
            }
        }
    }

    private fun filterRecipeList(value: String) {

        val filteredList = if (value.isBlank()) {
            _searchRecipeState.value.recipeList
        } else {
            _searchRecipeState.value.recipeList.filter { it.name.contains(value, ignoreCase = true) }
        }
        _searchRecipeState.update { it.copy(filteredRecipeList = filteredList) }
    }


    fun onAction(action: SearchRecipeAction) {
        when (action) {

            // 필터링 수행
            is SearchRecipeAction.FilterSearchChange -> {
                _searchRecipeState.update {
                    it.copy(filterText = action.value)
                }
                filterRecipeList(action.value)
            }

            // 필터링 기능을 위한 BottomSheet Action 정의
            is SearchRecipeAction.HandleBottomSheet -> {
                _searchRecipeState.update {
                    it.copy(
                        isBottomSheetVisible = action.isBottomSheetVisible
                    )
                }
            }

            is SearchRecipeAction.SearchRecipeDetail -> Logger.e("Recipe Detail 화면으로 이동 ")
        }
    }
}


