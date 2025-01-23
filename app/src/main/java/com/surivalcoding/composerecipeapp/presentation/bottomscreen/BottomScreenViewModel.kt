package com.surivalcoding.composerecipeapp.presentation.bottomscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeState
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//class BottomScreenViewModel : ViewModel() {
//    private val _state: MutableStateFlow<BottomScreenState> = MutableStateFlow(BottomScreenState())
//    val state = _state.asStateFlow()
//
//    init {
//    }
//
//    fun tabColorChange(tabId: Int) {
//        viewModelScope.launch {
//            _state.update {
//                println(tabId)
//                println("1${_state.value.isMainFocused}")
//                println("2${_state.value.isSavedRecipeFocused}")
//                println("3${_state.value.isThirdFocused}")
//                println("4${_state.value.isFourthFocused}")
//                when (tabId) {
//                    _state.value.savedRecipeTabId -> it.copy(
//                        isMainFocused = false,
//                        isSavedRecipeFocused = true,
//                        isThirdFocused = false,
//                        isFourthFocused = false
//                    )
//                    _state.value.thirdTabId -> it.copy(
//                        isMainFocused = false,
//                        isSavedRecipeFocused = false,
//                        isThirdFocused = true,
//                        isFourthFocused = false
//                    )
//                    _state.value.fourthTabId -> it.copy(
//                        isMainFocused = false,
//                        isSavedRecipeFocused = false,
//                        isThirdFocused = false,
//                        isFourthFocused = true
//                    )
//                    else -> it.copy(
//                        isMainFocused = true,
//                        isSavedRecipeFocused = false,
//                        isThirdFocused = false,
//                        isFourthFocused = false
//                    )
//                }
//            }
//        }
//    }
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(
//                modelClass: Class<T>,
//                extras: CreationExtras,
//            ): T {
//                // Get the Application object from extras
//                val application = checkNotNull(extras[APPLICATION_KEY])
//                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()
//
//                return BottomScreenViewModel(
//                ) as T
//            }
//        }
//    }
//}