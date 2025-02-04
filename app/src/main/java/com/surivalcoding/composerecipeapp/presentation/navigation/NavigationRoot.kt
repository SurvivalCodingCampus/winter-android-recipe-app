package com.surivalcoding.composerecipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.AppState
import com.surivalcoding.composerecipeapp.presentation.auth.signIn.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.auth.signIn.SignInViewModel
import com.surivalcoding.composerecipeapp.presentation.auth.signUp.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.auth.signUp.SignUpViewModel
import com.surivalcoding.composerecipeapp.presentation.main.MainScreen
import com.surivalcoding.composerecipeapp.presentation.main.home.HomeScreen
import com.surivalcoding.composerecipeapp.presentation.main.home.HomeViewModel
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesViewModel
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesViewModel
import com.surivalcoding.composerecipeapp.presentation.splash.SplashScreen

@Composable
fun NavigationRoot(
    appState: AppState
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToSignIn = appState::navigateToSignIn
            )
        }

        composable(Screen.SignIn.route) {
            val viewModel: SignInViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            SignInScreen(
                state = state,
                onEmailChange = viewModel::onEmailChange,
                onPasswordChange = viewModel::onPasswordChange,
                onSignInClick = appState::navigateToMain,
                onSignUpClick = appState::navigateToSignUp,
                onForgotPasswordClick = {},
                onGoogleSignInClick = {},
                onFacebookSignInClick = {},
            )
        }

        composable(Screen.SignUp.route) {
            val viewModel: SignUpViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            SignUpScreen(
                state = state,
                onNameChange = viewModel::onNameChange,
                onEmailChange = viewModel::onEmailChange,
                onPasswordChange = viewModel::onPasswordChange,
                onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
                onSignUpClick = appState::navigateToMain,
                onSignInClick = appState::navigateToSignInFromSignUp,
                onTermsChange = {},
                onGoogleSignUpClick = {},
                onFacebookSignUpClick = {},
            )
        }

        composable(Screen.Main.route) {
            MainScreen(appState = appState)
        }

        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            HomeScreen(
                state = state,
                onSearchClick = appState::navigateToSearchRecipes,
            )
        }

        composable(Screen.SavedRecipes.route) {
            val viewModel: SavedRecipesViewModel = viewModel(factory = SavedRecipesViewModel.Factory)
            val state by viewModel.state.collectAsStateWithLifecycle()
            SavedRecipeScreen(state = state, onBookmarkClick = viewModel::onBookmarkClick)
        }

        composable(Screen.SearchRecipes.route) {
            val viewModel: SearchRecipesViewModel = viewModel(factory = SearchRecipesViewModel.Factory)
            val state by viewModel.state.collectAsStateWithLifecycle()

            SearchRecipesScreen(
                state = state,
                onQueryChange = viewModel::fetchRecipes,
                onDismiss = {}
            )
        }
    }
}