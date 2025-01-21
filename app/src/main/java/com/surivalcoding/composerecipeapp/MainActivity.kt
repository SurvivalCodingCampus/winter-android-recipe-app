package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val viewModels: SavedRecipeViewModel by viewModels{
//            SavedRecipeViewModel.Factory
//        }

        setContent {
//            val viewModel: SavedRecipeViewModel = viewModel(
//                factory = SavedRecipeViewModel.Factory
//            )
//
//            val state = viewModel.state.collectAsStateWithLifecycle()
//
//            SavedRecipesScreen(
//                modifier = Modifier.fillMaxSize(),
//                state = state.value,
//                waitSavedRecipes = { viewModel.waitSavedRecipes() }
//            )

            val viewModel: SearchRecipeViewModel = viewModel(
                factory = SearchRecipeViewModel.Factory
            )

            val state by viewModel.state.collectAsStateWithLifecycle()

            SearchRecipesScreen(
                modifier = Modifier.fillMaxSize(),
                state = state,
                waitSavedRecipes = { viewModel.waitSearchRecipes() },
                onValueChange = { viewModel.onSearchQueryChanged(it) }
            )

        }
    }
}