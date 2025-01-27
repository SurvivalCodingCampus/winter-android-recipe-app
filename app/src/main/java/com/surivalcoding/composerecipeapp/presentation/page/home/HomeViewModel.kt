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

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        getMainRecipeList()
    }

    // 홈의 메인 레시피 불러오기
    private fun getMainRecipeList() {
        viewModelScope.launch {
            when (val result = getMainRecipeListUseCase.execute()) {
                is ResponseResult.Success -> {
                    _homeState.update {
                        it.copy(
                            recipeList = result.data,
                            filteredRecipeList = result.data
                        )
                    }

                    // 전체 리스트 불러온 후 해당 전체리스트를 통해 newRecipeList를 가져오도록 호출
                    getNewRecipeList()
                }

                is ResponseResult.Failure -> {
                    Logger.e("홈 화면 통신 불러오기 실패")
                    _homeState.update {
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
        _homeState.update {
            it.copy(pickerState = category)
        }

        // 필터링된 레시피 리스트 갱신
        _homeState.update { state ->
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

    // new Recipes 불러오기 -> 추후에 UseCase를 나누어서 날짜에 따라 최신순으로 불러와야할것 같음 현재 날자 데이터가 없어서 임시로 앞에서 부터 5개
    private fun getNewRecipeList() {
        viewModelScope.launch {
            // 전체 리스트에서 임시로 5개만 가져오기
            val newRecipeList = _homeState.value.recipeList.take(5)
            _homeState.update {
                it.copy(newRecipeList = newRecipeList)
            }
        }
    }


    /*
    * 사용자의 Action 처리
    * */
    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.FilterCategory -> TODO()
            HomeAction.SearchRecipe -> TODO()
        }
    }

}