package com.surivalcoding.composerecipeapp.presentation.splash

import Recipe
import androidx.lifecycle.SavedStateHandle
import com.surivalcoding.composerecipeapp.data.recipe.RecipeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.toRoute
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.navigation.Route
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



class SplashViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(SplashState())
    val state = _state.asStateFlow()

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY] as AppApplication)
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return SplashViewModel(
                    savedStateHandle
                ) as T
            }
        }
    }
}
