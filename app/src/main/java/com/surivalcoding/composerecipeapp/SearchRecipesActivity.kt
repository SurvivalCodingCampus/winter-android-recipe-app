package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class SearchRecipesActivity : ComponentActivity() {
    private val viewModel: SearchRecipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeRecipeAppTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()

                SearchRecipesScreen(
                    state = state,
                    onQueryChange = { query ->
                        viewModel.fetchRecipes(query)
                    }
                    , onDismiss = {}
                )
            }
        }
    }
}