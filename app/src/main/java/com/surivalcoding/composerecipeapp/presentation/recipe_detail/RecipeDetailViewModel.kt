package com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model

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
import com.surivalcoding.composerecipeapp.UserRouter
import com.surivalcoding.composerecipeapp.data.chef.User
import com.surivalcoding.composerecipeapp.data.chef.UserRepository
import com.surivalcoding.composerecipeapp.data.recipe.review.ReviewDto
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



class RecipeDetailViewModel(
    private val recipeRepository: RecipeRepository,
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val id = savedStateHandle.toRoute<UserRouter>().userId
    private val chefName = savedStateHandle.toRoute<UserRouter>().chefName

    private val _state = MutableStateFlow(RecipeDetailState())
    val state = _state.asStateFlow()


    init {
        getUserProfile(id)
        getRecipeDetail(chefName)
    }


    private fun getUserProfile(id : Int) {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            when (val result = userRepository.getUserById(id)) {
                is RResult.Success -> {
                    _state.update {
                        it.copy(
                            chefProfile = result.data
                        )
                    }
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }

                is RResult.Error -> {
                    _state.update {
                        it.copy(
                            chefProfile = User(
                                id = 0,
                                name = "",
                                image = "",
                                address = ""
                            )
                        )
                    }

                }
            }
        }
    }

    private fun getRecipeDetail(chefName: String) {
        viewModelScope.launch {
            when (val result = recipeRepository.getSearchRecipes(chefName)) {
                is RResult.Success -> {
                    _state.update {
                        it.copy(
                            recipes = result.data
                        )
                    }
                }

                is RResult.Error -> {
                    _state.update {
                        it.copy(
                            recipes = emptyList()
                        )
                    }
                }
            }
        }
    }


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

                return RecipeDetailViewModel(
                    application.recipeRepository,
                    application.userRepository,
                    savedStateHandle,
                ) as T
            }
        }
    }
}
