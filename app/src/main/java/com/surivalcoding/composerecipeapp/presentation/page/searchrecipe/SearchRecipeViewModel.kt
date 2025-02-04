package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.usecase.GetMainRecipeListUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetSearchKeywordUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.SaveSearchKeywordUseCase
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.LoadingState
import com.surivalcoding.composerecipeapp.util.NetworkManager
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val getMainRecipeListUseCase: GetMainRecipeListUseCase,
    private val saveSearchKeywordUseCase: SaveSearchKeywordUseCase,
    private val getSearchKeywordUseCase: GetSearchKeywordUseCase,
    private val networkManager: NetworkManager
) : ViewModel() {

    private val _searchRecipeState = MutableStateFlow(SearchRecipesState())
    val searchRecipeState = _searchRecipeState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    init {
        networkManager.registerNetworkCallback()
        checkNetworkState()
        getRecipeList()
    }

    override fun onCleared() {
        super.onCleared()
        networkManager.unRegisterNetworkCallback()
    }


    // 네트워크 상태 체크
    private fun checkNetworkState() {
        viewModelScope.launch {
            networkManager.isConnected.collectLatest { isConnected ->
                if (!isConnected) {
                    _uiEvent.emit(UiEvent.ShowSnackBar("네트워크 연결을 확인해주세요"))
                }
            }
        }
    }


    // 앱 실행 시 마지막 검색 키워드를 한 번 불러와 필터링
    private fun loadLastSearchKeyword() {
        viewModelScope.launch {
            getSearchKeywordUseCase.execute().firstOrNull()?.let { keyword ->
                // 마지막 검색어가 있으면 filterText에 설정, 없으면 빈칸
                _searchRecipeState.update { it.copy(filterText = "", filteredRecipeList = filterRecipeListInternal(it.recipeList, keyword)) }
            }
        }
    }

    // 검색어 저장
    private fun filterRecipeList(value: String) {
        val filteredList = filterRecipeListInternal(_searchRecipeState.value.recipeList, value)
        _searchRecipeState.update { it.copy(filteredRecipeList = filteredList, filterText = value) }

        viewModelScope.launch {
            saveSearchKeywordUseCase.execute(value) // ✨ 마지막 검색어 즉시 저장
        }
    }


    // 검색어에 따라 필터링
    private fun filterRecipeListInternal(recipeList: List<Recipe>, value: String): List<Recipe> {
        return if (value.isBlank()) {
            recipeList
        } else {
            recipeList.filter { it.name.contains(value, ignoreCase = true) }
        }
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
                    _searchRecipeState.update { it.copy(recipeList = result.data, filteredRecipeList = result.data) }
                    loadLastSearchKeyword()
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

    private fun applyFilter() {
        val (selectedTime, selectedRate, selectedCategory) = _searchRecipeState.value.filterState

        Logger.e("필터링할 녀석들 selectedTime: $selectedTime, selectedRate: $selectedRate, selectedCategory: $selectedCategory")

        _searchRecipeState.value = _searchRecipeState.value.copy(
            filteredRecipeList = _searchRecipeState.value.filteredRecipeList.filter { recipe ->
                (selectedTime == Time.All.name || recipe.time == selectedTime) &&
                        (selectedRate == 0 || recipe.ratingInt == selectedRate) &&
                        (selectedCategory == Category.All.name || recipe.category == selectedCategory)
            }
        )
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
            is SearchRecipeAction.UpdateFilter -> {
                _searchRecipeState.update { it.copy(filterState = action.filterState) }
            }

            SearchRecipeAction.ApplyFilter -> {
                // 최종 필터링 적용
                applyFilter()
            }
        }
    }
}


