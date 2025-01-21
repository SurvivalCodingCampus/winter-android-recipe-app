package com.surivalcoding.composerecipeapp.navigation

import Recipe
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.surivalcoding.composerecipeapp.presentation.recently_search_recipe.RecipeSearchScreen
import com.surivalcoding.composerecipeapp.presentation.recipe_detail.RecipeDetailScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.RecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeDetailViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeSearchViewModel
import com.surivalcoding.composerecipeapp.presentation.sign_in.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.sign_up.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.splash.SplashScreen
import com.surivalcoding.composerecipeapp.presentation.splash.SplashState
import com.surivalcoding.composerecipeapp.presentation.splash.SplashViewModel
import kotlinx.serialization.Serializable


@Serializable
object Main

@Serializable
object RecipeRouter

sealed interface Route {

    @Serializable
    object Main : Route

    @Serializable
    object Recipe : Route

    @Serializable
    object SignIn : Route

    @Serializable
    object SignUp : Route

    @Serializable
    data class RecipeDetail(val userId: Int, val chefName: String) : Route

    @Serializable
    data class User(val userId: Int, val chefName: String) : Route

    @Serializable
    object RecentlySearchRecipe : Route
}

@Composable
fun NavigationRoot(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Route.Main
    ) {
        composable<Route.Main> {
            val viewModel = viewModel<SplashViewModel>(factory = SplashViewModel.Factory)
            val state = viewModel.state.collectAsStateWithLifecycle().value

            SplashScreen(state, onStartClick = {
                toSignInGraph(navController)
            })
        }

        composable<Route.SignIn> {
            Scaffold { innerPadding ->
                SignInScreen(modifier = Modifier.padding(innerPadding),
                    onSignInClick = {
                        toRecipeGraph(navController)
                    },
                    onForgotPasswordClick = {},
                    onGoogleSignInClick = {},
                    onFacebookSignInClick = {},
                    onSignUpClick = {
                        toSignUpGraph(navController)
                    })

            }

        }

        composable<Route.SignUp> {
            Scaffold { innerPadding ->
                SignUpScreen(modifier = Modifier.padding(innerPadding), onSignUpClick = {
                    toSignUpGraph(navController)
                }, onGoogleSignInClick = {}, onFacebookSignInClick = {}, onSignInClick = {
                    toSignInGraph(navController)
                }) { }

            }

        }
        composable<Route.Recipe> { backStackEntry ->
            val viewModel = viewModel<RecipeViewModel>(factory = RecipeViewModel.Factory)
            val state by viewModel.state.collectAsStateWithLifecycle()

            Scaffold { innerPadding ->
                SavedRecipesScreen(
                    modifier = Modifier.padding(innerPadding),
                    state = state,
                    onRecipeClick = { recipe ->
                        toRecipeDetailGraph(navController, userId = 1, recipe = recipe)
                    },
                    onBookmarkClick = {},
                )

            }
        }
        composable<Route.RecipeDetail> { backStackEntry ->
            backStackEntry.toRoute<Route.Recipe>()
            val viewModel =
                viewModel<RecipeDetailViewModel>(factory = RecipeDetailViewModel.Factory)
            val state by viewModel.state.collectAsStateWithLifecycle()
            Scaffold { innerPadding ->
                RecipeDetailScreen(
                    state = state,
                    modifier = Modifier.padding(innerPadding),
                    onBackClick = { navController.popBackStack() },
                )

            }
        }


        composable<Route.RecentlySearchRecipe> { backStackEntry ->
            val viewModel =
                viewModel<RecipeSearchViewModel>(factory = RecipeSearchViewModel.Factory)
            val state by viewModel.state.collectAsStateWithLifecycle()

            RecipeSearchScreen(state = state,
                onValueChange = { newKeyword -> viewModel.searchRecipes(newKeyword) },
                onSearching = { isSearching -> viewModel.onSearching(isSearching) })
        }

    }
}

private fun NavGraphBuilder.toMainGraph(navController: NavHostController) {
    navController.navigate(Route.SignIn) {
        popUpTo(Route.SignUp) {
            inclusive = true
        }
    }
}

private fun NavGraphBuilder.toSignInGraph(navController: NavHostController) {
    navController.navigate(Route.SignIn) {
        popUpTo(Route.SignUp) {
            inclusive = true
        }
    }
}

private fun NavGraphBuilder.toSignUpGraph(navController: NavHostController) {
    navController.navigate(Route.SignUp) {
        popUpTo(Route.SignIn) {
            inclusive = true
        }
    }
}

private fun NavGraphBuilder.toRecipeGraph(navController: NavHostController) {
    navController.navigate(Route.Recipe)
}

private fun NavGraphBuilder.toRecipeDetailGraph(
    navController: NavHostController, userId: Int, recipe: Recipe
) {
    navController.navigate(
        Route.RecipeDetail(
            userId = userId, chefName = recipe.chef
        )
    )
}
