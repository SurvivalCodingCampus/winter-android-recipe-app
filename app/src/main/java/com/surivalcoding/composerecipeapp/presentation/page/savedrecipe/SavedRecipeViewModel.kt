package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetBookmarkedRecipesUseCase
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedRecipeViewModel @Inject constructor(
    private val getBookmarkedRecipesUseCase: GetBookmarkedRecipesUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase
) : ViewModel() {

    private val _savedRecipeState = MutableStateFlow(SavedRecipeState())
    val savedRecipeState = _savedRecipeState.asStateFlow()

    init {
        getAllBookmarkList()
    }

    // 전체 북마크 리스트 가져오기
    private fun getAllBookmarkList() {
        _savedRecipeState.update { it.copy(loadingState = LoadingState(isLoading = true)) }
        viewModelScope.launch {
            getBookmarkedRecipesUseCase.execute().collect { result ->
                when (result) {
                    is ResponseResult.Success -> {
                        _savedRecipeState.update {
                            it.copy(
                                bookMarkList = result.data,
                                loadingState = LoadingState(isLoading = false)
                            )
                        }
                    }

                    is ResponseResult.Failure -> {
                        Logger.e("북마크 리스트 불러오기 실패")
                        _savedRecipeState.update { it.copy(loadingState = LoadingState(isLoading = false)) }
                    }

                }
            }
        }
    }


    fun onAction(action: SavedRecipeAction) {
        when (action) {

            is SavedRecipeAction.SearchRecipeDetail -> Logger.e("레시피 상세 화면으로 이동")

            is SavedRecipeAction.DeleteBookmark -> {
                Logger.e("북마크 삭제")
                viewModelScope.launch {
                    deleteBookmarkUseCase.execute(action.recipeId)
                }
            }
        }
    }
}