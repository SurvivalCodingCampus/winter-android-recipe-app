package com.surivalcoding.composerecipeapp

import RecipeDtoRouter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.recipe_detail.RecipeDetailScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeDetailViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeSearchViewModel
import com.surivalcoding.composerecipeapp.presentation.recently_search_recipe.RecipeBeforeSearchScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@Serializable
data class UserRouter(val userId: Int, val chefName: String)


class RecipeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecipeAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = RecipeDtoRouter(id = "1")
                ) {
                    composable<RecipeDtoRouter> { backStackEntry ->
                        val viewModel =
                            viewModel<RecipeViewModel>(factory = RecipeViewModel.Factory)
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        SavedRecipesScreen(
                            state = state,
                            onRecipeClick = { recipe ->
                                navController.navigate(
                                    route = UserRouter(userId = 1, chefName = recipe.chef)
                                )
                            },
                            onBookmarkClick = {},
                        )
                    }

                    composable<UserRouter>
                    { backStackEntry ->
                        backStackEntry.toRoute<UserRouter>()
                        val viewModel =
                            viewModel<RecipeDetailViewModel>(factory = RecipeDetailViewModel.Factory)
                        val state by viewModel.state.collectAsStateWithLifecycle()
                        RecipeDetailScreen(
                            state = state,
                            onBackClick = { navController.popBackStack() },
                        )
                    }


//                    composable<UserDto> { backStackEntry ->
//                        val viewModel = viewModel<RecipeSearchViewModel>()
//                        val state by viewModel.state.collectAsStateWithLifecycle()
//
//                        RecipeBeforeSearchScreen(
//                            state = state,
//                            onValueChange = viewModel::searchRecipes,
//                        )
//                    }
                }
            }
        }
    }
}

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecipeAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = RecipeDtoRouter(id = "1")
                ) {
                    composable<RecipeDtoRouter> { backStackEntry ->
                        val viewModel =
                            viewModel<RecipeSearchViewModel>(factory = RecipeSearchViewModel.Factory)
                        val state by viewModel.state.collectAsStateWithLifecycle()


                        RecipeBeforeSearchScreen(
                            state = state,
                            onValueChange = viewModel::searchRecipes,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeRecipeAppTheme {
    }
}