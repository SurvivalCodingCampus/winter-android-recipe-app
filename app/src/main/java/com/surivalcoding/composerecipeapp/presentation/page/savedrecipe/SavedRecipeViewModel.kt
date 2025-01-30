package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookMarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetBookMarkListUseCase
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedRecipeViewModel @Inject constructor(
    private val deleteBookMarkUseCase: DeleteBookMarkUseCase,
    private val getBookMarkListUseCase: GetBookMarkListUseCase,
) : ViewModel() {

    private val _savedRecipeState = MutableStateFlow(SavedRecipeState())
    val savedRecipeState = _savedRecipeState.asStateFlow()

    init {
        getBookMarkList()
    }

    private fun getBookMarkList() {

        _savedRecipeState.update {
            it.copy(
                loadingState = LoadingState(isLoading = true)
            )
        }
        viewModelScope.launch {
            when (val result = getBookMarkListUseCase.execute()) {
                is ResponseResult.Success -> {
                    Log.e("값확인", "전체: ${result.data} ${result.data.size}")
                    _savedRecipeState.update {
                        it.copy(
                            bookMarkList = result.data.toList()
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
                    _savedRecipeState.update {
                        it.copy(
                            bookMarkList = emptyList()
                        )
                    }
                }
            }

            _savedRecipeState.update {
                it.copy(
                    loadingState = LoadingState(isLoading = false)
                )
            }
        }
    }

    private fun deleteBookMark(id: Int) {
        viewModelScope.launch {
            when (val result = deleteBookMarkUseCase.execute(id)) {
                is ResponseResult.Success -> {
                    _savedRecipeState.update {
                        it.copy(
                            bookMarkList = result.data.toList()
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Log.e("Saved", "삭제 실패")
                }
            }
        }
    }

    fun onAction(action: SavedRecipeAction) {
        when (action) {
            is SavedRecipeAction.DeleteBookmark -> {
                deleteBookMark(id = action.recipeId)
            }

            is SavedRecipeAction.SearchRecipeDetail -> Logger.e("레시피 상세 화면으로 이동")
        }
    }
}