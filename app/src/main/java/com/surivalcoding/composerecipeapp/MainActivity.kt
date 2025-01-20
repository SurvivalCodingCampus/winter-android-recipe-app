package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.surivalcoding.composerecipeapp.presentation.saved_recipe.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipe.SavedRecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: SavedRecipeViewModel by viewModels { SavedRecipeViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 테스트용 코드
        lifecycleScope.launch {
            val repository = (application as AppApplication).recipeRepository
            val recipes = repository.getSavedRecipes()
            println("Loaded recipes: $recipes")
        }

        setContent {
            ComposeRecipeAppTheme {
                val recipes by viewModel.recipes.collectAsState()
                SavedRecipeScreen(recipes)
            }
        }
    }
}