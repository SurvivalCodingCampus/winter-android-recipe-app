package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.presentation.navigation.Screen
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(navController, coroutineScope) {
        AppState(navController, coroutineScope)
    }
}

@Stable
class AppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    fun navigateToSignIn() {
        navController.navigate(Screen.SignIn.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    fun navigateToSignUp() {
        navController.navigate(Screen.SignUp.route)
    }

    fun navigateToMain() {
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.SignIn.route) { inclusive = true }
        }
    }

    fun navigateToSignInFromSignUp() {
        navController.navigateUp()
    }

    fun navigateToSearchRecipes() {
        navController.navigate(Screen.SearchRecipes.route)
    }
}