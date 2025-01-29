package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _recipeDetailState = MutableStateFlow(RecipeDetailState())
    val recipeDetailState = _recipeDetailState.asStateFlow()


    init {
        val jsonRecipe = savedStateHandle.get<String>("recipeDetail")
        Logger.e("디테일 정보: $jsonRecipe")
        kotlin.runCatching {
            jsonRecipe?.let {
                val recipe = Json.decodeFromString<Recipe>(it)
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    recipeDetail = recipe
                )
            }
        }.onFailure {
            Logger.e("Error decoding recipeDetail")
        }


    }

    fun onAction(action: RecipeDetailAction) {
        when (action) {
            is RecipeDetailAction.FilterCategory -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    filterButtonState = action.filterButtonState
                )
            }
        }
    }
}