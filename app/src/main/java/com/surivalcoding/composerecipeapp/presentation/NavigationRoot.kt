package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.surivalcoding.composerecipeapp.presentation.sign_in.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.sign_up.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.splashscreen.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

private sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data object SignUp : Route
}

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph,
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navHostController: NavHostController) {
    navigation<AuthGraph>(
        startDestination = Route.Splash
    ) {
        composable<Route.Splash> {
            SplashScreen(
                onClick = {
                    navHostController.navigate(Route.SignIn) {
                        popUpTo(Route.Splash) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
        composable<Route.SignIn> {
            SignInScreen(
                onSignUpClick = {
                    navHostController.navigate(Route.SignUp) {
                        popUpTo(Route.SignIn) {
                            inclusive = true // Route.SignIn 화면도 제거
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
        composable<Route.SignUp> {
            SignUpScreen(
                onSignInClick = {
                    navHostController.navigate(Route.SignIn) {
                        popUpTo(Route.SignUp) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}