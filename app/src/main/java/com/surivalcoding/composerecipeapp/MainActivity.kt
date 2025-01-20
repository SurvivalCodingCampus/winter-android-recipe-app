package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeScreenViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: SavedRecipeScreenViewModel by viewModels{
            SavedRecipeScreenViewModel.Factory
        }

        setContent {
            val savedRecipes = viewModel.savedRecipes.collectAsState()
            SavedRecipesScreen(
                modifier = Modifier.fillMaxSize(),
                recipes = savedRecipes.value
            )
        }
    }
}