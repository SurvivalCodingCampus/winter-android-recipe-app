package com.surivalcoding.composerecipeapp.presentation.component.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipeRepository = RecipeRepositoryImpl(RecipeDataSourceImpl()),
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state = MutableStateFlow(SavedRecipesState())
    val state = _state.asStateFlow()

    private fun updateDataCount() {
        _state.update {
            it.copy(
                dataCount = repository.getDataCount()
            )
        }
    }

    private suspend fun updateRecipeData() {
        _state.update {
            it.copy(
                foodImages = repository.getFoodImages(),
                titles = repository.getRecipeTitles(),
                chefNames = repository.getChefNames(),
                cookingTimeMinutes = repository.getCookingTimes(),
                rates = repository.getRatings(),
            )
        }
    }

    private fun loadStart() {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
    }

    private fun loadFinished() {
        _state.update {
            it.copy(
                isLoading = false
            )
        }
    }

    private fun updateCountOfSearchedResult(query: String) {
        _state.update {
            it.copy(
                dataCount = repository.getSearchedRecipes(query).size
            )
        }
    }

    private fun updateTypingText(newText: TextFieldValue) {
        _state.update {
            it.copy(
                typing = newText
            )
        }
    }
    suspend fun injectRecipeDataToState() {
        updateDataCount()
        updateRecipeData()
        loadFinished()
    }

    fun startSearching() {
        _state.update {
            it.copy(
                isSearching = true
            )
        }
    }

    fun endSearching() {
        _state.update {
            it.copy(
                isSearching = false
            )
        }
    }

    fun onValueChanged(newText: TextFieldValue) {
        if(newText.text == "") {
            endSearching()
        } else {
            startSearching()
        }

        viewModelScope.launch {
            onInputTextChanged(newText)
        }
        _state.update {
            it.copy(
                typing = newText
            )
        }
    }

    private suspend fun updateSearchedRecipes(query: String) {
        _state.update {
            it.copy(
                foodImages = repository.getFoodImages(query),
                titles = repository.getRecipeTitles(query),
                chefNames = repository.getChefNames(query),
                rates = repository.getRatings(query)
            )
        }
    }

    suspend fun onInputTextChanged(newText: TextFieldValue) {
        loadStart()
        updateCountOfSearchedResult(newText.text)
        updateSearchedRecipes(newText.text)
        loadFinished()
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