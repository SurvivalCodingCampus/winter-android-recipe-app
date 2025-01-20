package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.data.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.day19.repository.RecipeRepository
// _savedRecipes는 MutableStateFlow로, ViewModel 내부에서만 데이터 변경이 가능하다.
// savedRecipes는 StateFlow로 외부(예: UI 계층)에 데이터 상태를 노출하는 역할을 한다.
// asStateFlow를 통해 MutableStateFlow를 불변 상태로 변환하여 외부에서는 읽기 전용으로 사용할 수 있게 만든다.
class SavedRecipesViewModel(private val recipeRepository: RecipeRepository): ViewModel() {

   private var _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    val savedRecipes: StateFlow<List<Recipe>> = _savedRecipes.asStateFlow()

    // ViewModel이 생성될 때 즉시 저장된 레시피 데이터를 불러온다.
    init {
        getSavedRecipes()
    }

    fun getSavedRecipes() {
        viewModelScope.launch {     // 비동기 작업 실행
            _savedRecipes.value = recipeRepository.getSavedRecipes()
        }
    }
    companion object {
        // 뷰 모델 생성하는 팩토리 패턴
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return SavedRecipesViewModel(
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}