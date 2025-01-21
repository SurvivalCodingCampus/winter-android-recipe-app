package com.surivalcoding.composerecipeapp.presentation.component.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.composerecipeapp.presentation.component.AppApplication
import com.surivalcoding.composerecipeapp.presentation.component.SavedRecipesState
import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.presentation.component.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.presentation.component.repository.RecipeRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel(
    private val repository: RecipeRepository = RecipeRepositoryImpl(RecipeDataSourceImpl()),
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _state = MutableStateFlow(SavedRecipesState())
    val state = _state.asStateFlow()

    suspend fun getDataCount(): Int {
        val data = repository.getDataCount()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }
    suspend fun getFoodImage(): List<String> {
        val data = repository.getFoodImage()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }
    suspend fun getRecipeTitles(): List<String> {
        val data = repository.getRecipeTitles()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }
    suspend fun getChefNames(): List<String> {
        val data = repository.getChefNames()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }
    suspend fun getCookingTimes(): List<Int> {
        val data = repository.getCookingTimes()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }
    suspend fun getRatings(): List<Float> {
        val data = repository.getRatings()
        _state.update {
            it.copy(
                isLoading = false
            )
        }
        return data
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val recipeRepository = (this[APPLICATION_KEY] as AppApplication).recipeRepository
                RecipeViewModel(
                    repository = recipeRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
}