package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme


class SavedRecipeActivity : ComponentActivity() {
    private val viewModel: SavedRecipesViewModel by viewModels { SavedRecipesViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeRecipeAppTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()
                SavedRecipeScreen(state)
            }
        }
    }
}