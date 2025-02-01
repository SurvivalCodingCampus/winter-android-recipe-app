package com.surivalcoding.composerecipeapp.presentation.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.data.mapper.toMapper
import com.surivalcoding.composerecipeapp.domain.usecase.AddBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetMainRecipeListUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.SaveAllRecipesUseCase
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
    private val getMainRecipeListUseCase: GetMainRecipeListUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val saveAllRecipesUseCase: SaveAllRecipesUseCase
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
                            filteredRecipeList = result.data,
                            newRecipeList = result.data.take(5)
                        )
                    }

                    // 전체 리스트 Room에 저장
                    saveAllRecipesUseCase.execute(result.data)

                    // 홈화면 제일 하단 메인 리스트 5개 불러오기(추후에 수정필요)
                    getNewRecipeList()
                }

                is ResponseResult.Failure -> {
                    Logger.e("홈 화면 통신 불러오기 실패")
                    _homeState.update {
                        it.copy(
                            recipeList = emptyList(),
                            filteredRecipeList = emptyList(),
                            newRecipeList = emptyList()
                        )
                    }
                }
            }

        }
    }

    // 카테고리 클릭 처리
    private fun onSelectCategory(pickerState: PickerState) {
        _homeState.update {
            it.copy(pickerState = pickerState)
        }

        // 필터링된 레시피 리스트 갱신
        _homeState.update { state ->
            val filteredList = if (pickerState.buttonState.displayName == Category.All.displayName) {
                state.recipeList
            } else {
                state.recipeList.filter { recipe ->
                    recipe.category == pickerState.buttonState.displayName
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
    * 사용자의 Action
    * */
    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.SearchRecipe -> Logger.e("Search Recipe 화면으로 이동")
            is HomeAction.FilterCategory -> onSelectCategory(pickerState = action.pickerState)
            is HomeAction.AddBookmark -> {      // 북마크 추가
                Logger.e("북마크 추가!!")
                viewModelScope.launch {
                    addBookmarkUseCase.execute(action.id)
                }
            }
        }
    }
}