package com.surivalcoding.composerecipeapp.presentation.component.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.composerecipeapp.presentation.component.AppApplication
import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.presentation.component.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.presentation.component.repository.RecipeRepositoryImpl

class RecipeViewModel(
    private val repository: RecipeRepository = RecipeRepositoryImpl(RecipeDataSourceImpl()),
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    fun getDataCount(): Int {
        return repository.getDataCount()
    }
    fun getFoodImage(): List<String> {
        return repository.getFoodImage()
    }
    fun getRecipeTitles(): List<String> {
        return repository.getRecipeTitles()
    }
    fun getChefNames(): List<String> {
        return repository.getChefNames()
    }
    fun getCookingTimes(): List<Int> {
        return repository.getCookingTimes()
    }
    fun getRatings(): List<Float> {
        return repository.getRatings()
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