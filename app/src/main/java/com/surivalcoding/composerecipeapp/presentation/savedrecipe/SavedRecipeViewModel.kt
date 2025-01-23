package com.surivalcoding.composerecipeapp.presentation.savedrecipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.airbnb.lottie.utils.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookMarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetBookMarkListUseCase
import com.surivalcoding.composerecipeapp.util.AppApplication
import com.surivalcoding.composerecipeapp.util.ResponseResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedRecipeViewModel(
    private val deleteBookMarkUseCase: DeleteBookMarkUseCase,
    private val getBookMarkListUseCase: GetBookMarkListUseCase,
) : ViewModel() {

    private val _bookMarkList = MutableStateFlow(SavedRecipeState())
    val bookMarkList = _bookMarkList.asStateFlow()

    private val _loadingState = MutableStateFlow(LoadingState())
    val loadingState = _loadingState.asStateFlow()



    init {
        getBookMarkList()
    }

    private fun getBookMarkList() {
        viewModelScope.launch {
            when (val result = getBookMarkListUseCase.execute()) {
                is ResponseResult.Success -> {
                    Log.e("값확인", "전체: ${result.data} ${result.data.size}")
                    _bookMarkList.update {
                        it.copy(
                            bookMarkList = result.data.toList()
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Log.e("RecipeViewModel", "통신 에러 ${result.error.message}")
                    _bookMarkList.update {
                        it.copy(
                            bookMarkList = emptyList()
                        )
                    }
                }
            }
        }
    }

    fun deleteBookMark(id: Int) {
        viewModelScope.launch {
            when (val result = deleteBookMarkUseCase.execute(id)) {
                is ResponseResult.Success -> {
                    _bookMarkList.update {
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


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val deleteBookMarkUseCase = (this[APPLICATION_KEY] as AppApplication).deleteBookMarkUseCase
                val getBookMarkListUseCase = (this[APPLICATION_KEY] as AppApplication).getBookMarkListUseCase
                SavedRecipeViewModel(
                    deleteBookMarkUseCase = deleteBookMarkUseCase,
                    getBookMarkListUseCase = getBookMarkListUseCase
                )
            }
        }
    }
}