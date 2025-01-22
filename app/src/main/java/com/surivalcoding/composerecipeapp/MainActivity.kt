package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    //private val viewModel: SavedRecipeViewModel by viewModels { SavedRecipeViewModel.Factory }
    private val viewModel: SearchRecipeViewModel by viewModels { SearchRecipeViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRecipeAppTheme {
                //val recipes by viewModel.recipes.collectAsState()
                //val savedRecipes = viewModel.recipes.collectAsState()
                //SavedRecipesScreen(viewModel.state.collectAsState().value)
                SearchRecipeScreen(viewModel.state.collectAsState().value, onValueChange = viewModel::onSearchTextChange)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeRecipeAppTheme {
        Greeting("Android")
    }
}