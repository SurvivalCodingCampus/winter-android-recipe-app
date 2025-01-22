package com.surivalcoding.composerecipeapp.navigation

import Recipe
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.surivalcoding.composerecipeapp.presentation.bottomAppBar.BottomAppBarScreen
import com.surivalcoding.composerecipeapp.presentation.home.HomeScreen
import com.surivalcoding.composerecipeapp.presentation.recently_search_recipe.RecipeSearchScreen
import com.surivalcoding.composerecipeapp.presentation.recipe_detail.RecipeDetailScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.RecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.home.HomeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeDetailViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeSearchViewModel
import com.surivalcoding.composerecipeapp.presentation.sign_in.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.sign_up.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.splash.SplashScreen
import com.surivalcoding.composerecipeapp.presentation.splash.SplashViewModel

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()


    NavHost(
        navController = navController, startDestination = Route.Splash,
    ) {
        composable<Route.Splash> {
            val homeViewModel = viewModel<HomeViewModel>(factory = HomeViewModel.Factory)
            val viewModel = viewModel<SplashViewModel>(factory = SplashViewModel.Factory)
            val state = viewModel.state.collectAsStateWithLifecycle().value

            homeViewModel.selectRoute(Route.Splash)

            SplashScreen(
                state, onStartClick = {
                    toSignInGraph(navController)
                }
            )
        }
        composable<Route.SignIn> {
            NavigationMain()
        }
    }
}

@Composable
fun NavigationMain() {
    val navController = rememberNavController()
    val viewModel = viewModel<HomeViewModel>(factory = HomeViewModel.Factory)
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            BottomAppBarScreen(state = state,
                onClickToHome = {
                    viewModel.selectRoute(Route.Home)
                    navController.navigate(Route.Recipe)
                },
                onClickToSavedRecipes = {
                    viewModel.selectRoute(Route.RecentlySearchRecipe)
                    navController.navigate(Route.RecentlySearchRecipe)
                })

        }
    ) { innerPadding ->
        NavHost(
            navController = navController, startDestination = Route.SignIn,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Route.Home> {
                HomeScreen(
                    state = state,
                    modifier = Modifier,
                    onValueChange = {},
                    onSearching = {}
                )
            }
            composable<Route.SignIn> {
                SignInScreen(modifier = Modifier,
                    onSignInClick = {
                        toHomeGraph(navController)
                    },
                    onForgotPasswordClick = {},
                    onGoogleSignInClick = {},
                    onFacebookSignInClick = {},
                    onSignUpClick = {
                        toSignUpGraph(navController)
                    })
            }
            composable<Route.SignUp> {
                SignUpScreen(modifier = Modifier, onSignUpClick = {
                    toSignUpGraph(navController)
                }, onGoogleSignInClick = {}, onFacebookSignInClick = {}, onSignInClick = {
                    toSignInGraph(navController)
                }) { }


            }
            composable<Route.Recipe> { backStackEntry ->
                val recipeViewModel = viewModel<RecipeViewModel>(factory = RecipeViewModel.Factory)
                val recipeState by recipeViewModel.state.collectAsStateWithLifecycle()


                SavedRecipesScreen(
                    modifier = Modifier,
                    state = recipeState,
                    onRecipeClick = { recipe ->
                        toRecipeDetailGraph(navController, userId = 1, recipe = recipe)
                    },
                    onBookmarkClick = {},
                )

            }
            composable<Route.RecipeDetail> { backStackEntry ->
                backStackEntry.toRoute<Route.Recipe>()
                val recipeDetailViewModel =
                    viewModel<RecipeDetailViewModel>(factory = RecipeDetailViewModel.Factory)
                val recipeDetailState by recipeDetailViewModel.state.collectAsStateWithLifecycle()
                RecipeDetailScreen(
                    state = recipeDetailState,
                    modifier = Modifier,
                    onBackClick = { navController.popBackStack() },
                )

            }

            composable<Route.RecentlySearchRecipe> { backStackEntry ->
                val recipeSearchViewModel =
                    viewModel<RecipeSearchViewModel>(factory = RecipeSearchViewModel.Factory)
                val recipeSearchState by recipeSearchViewModel.state.collectAsStateWithLifecycle()

                RecipeSearchScreen(state = recipeSearchState,
                    onValueChange = { newKeyword -> recipeSearchViewModel.searchRecipes(newKeyword) },
                    onSearching = { isSearching -> recipeSearchViewModel.onSearching(isSearching) })
            }
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

fun NavGraphBuilder.toHomeGraph(navController: NavHostController) {
    navController.navigate(Route.Home) {
    }
}

private fun NavGraphBuilder.toSignInGraph(navController: NavHostController) {
    navController.navigate(Route.SignIn) {
        popUpTo(Route.Splash) {
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

fun NavGraphBuilder.toRecipeGraph(navController: NavHostController) {
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
