package com.surivalcoding.composerecipeapp.presentation.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.GetMainRecipeListUseCase
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMainRecipeListUseCase: GetMainRecipeListUseCase
) : ViewModel() {

    private val _mainRecipeState = MutableStateFlow(MainRecipeState())
    val mainRecipeState = _mainRecipeState.asStateFlow()

    private val _pickerState = MutableStateFlow(PickerState())
    val pickerState = _pickerState.asStateFlow()


    init {
        getMainRecipeList()
    }

    // 홈의 메인 레시피 불러오기
    private fun getMainRecipeList() {
        viewModelScope.launch {
            when (val result = getMainRecipeListUseCase.execute()) {
                is ResponseResult.Success -> {
                    _mainRecipeState.update {
                        it.copy(
                            recipeList = result.data,
                            filteredRecipeList = result.data
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Logger.e("홈 화면 통신 불러오기 실패")
                    _mainRecipeState.update {
                        it.copy(
                            recipeList = emptyList(),
                            filteredRecipeList = emptyList()
                        )
                    }
                }
            }
        }

    }


    // 카테고리 클릭 처리
    fun onSelectCategory(category: PickerState) {
        _pickerState.update {
            it.copy(buttonState = category.buttonState)
        }

        // 필터링된 레시피 리스트 갱신
        _mainRecipeState.update { state ->
            val filteredList = if (category.buttonState.displayName == Category.All.displayName) {
                state.recipeList
            } else {
                state.recipeList.filter { recipe ->
                    recipe.category == category.buttonState.displayName
                }
            }

            Logger.e("카피하기전 리스트 :${filteredList.size}")
            state.copy(filteredRecipeList = filteredList)
        }
    }

}