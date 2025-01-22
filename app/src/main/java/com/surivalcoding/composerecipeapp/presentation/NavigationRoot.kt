package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.sign_in.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.sign_up.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.splash.SplashScreen
import kotlinx.serialization.Serializable


@Serializable
data object AuthGraph

sealed interface Route {

    @Serializable
    data object Splash : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data object SignUp : Route


    @Serializable
    data class RecipeDetail(val id: Int) : Route //데이터 넘길게 있을때
}

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash.toString()
    ) {
        splashGraph(navController)
        signInGraph(navController)
        signUpGraph(navController)
    }
}

private fun NavGraphBuilder.splashGraph(navController: NavHostController) {
    composable(Route.Splash.toString()) {
        SplashScreen(
            onNextButtonClicked = {
                navController.navigate(Route.SignIn.toString()) {
                    popUpTo(Route.Splash.toString()) {
                        inclusive = true
                    }
                }
            },
        )
    }
}

private fun NavGraphBuilder.signInGraph(navController: NavHostController) {
    composable(Route.SignIn.toString()) { // Route.SignIn.toString() 사용
        SignInScreen(
            onEmailChanged = {},
            onPasswordChanged = {},
            onSignInClicked = {},
            onSocialSignInClicked = {},
            onSignUpClicked = {
                navController.navigate(Route.SignUp.toString())

            }
        ) // SignIn 화면
    }
}

private fun NavGraphBuilder.signUpGraph(navController: NavHostController) {
    composable(Route.SignUp.toString()) {
        SignUpScreen(
            onNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onTermsChange = {},
            onSignUpClick = {},
            onGoogleSignUpClick = {},
            onFacebookSignUpClick = {},
            onSignInClick = {}
        )

    }

}