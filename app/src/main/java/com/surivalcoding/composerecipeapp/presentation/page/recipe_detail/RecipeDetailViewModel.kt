package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.usecase.CopyLinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val copyLinkUseCase: CopyLinkUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _recipeDetailState = MutableStateFlow(RecipeDetailState())
    val recipeDetailState = _recipeDetailState.asStateFlow()

    init {
        // SearchRecipeScreen에서 해당 키값으로 데이터를 전달한후 여기서 받아서 처리함
        val jsonRecipe = savedStateHandle.get<String>("recipeDetail")
        Logger.e("디테일 정보: $jsonRecipe")


        // try - catch 대신 runCatching 사용
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
                    recipeCategoryButtonState = action.recipeDetailButtonState
                )
            }

            is RecipeDetailAction.HandleDropDown -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    isDropDownMenuVisible = action.isDropDownMenuVisible
                )

            }

            is RecipeDetailAction.CopyLink -> {
                copyLinkUseCase.execute(action.link)
            }

            is RecipeDetailAction.HandleDialog -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    showDialog = action.isVisible
                )
            }
        }
    }
}