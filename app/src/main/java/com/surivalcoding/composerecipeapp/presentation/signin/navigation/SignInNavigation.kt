package com.surivalcoding.composerecipeapp.presentation.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.surivalcoding.composerecipeapp.presentation.intro.navigation.IntroRoute
import com.surivalcoding.composerecipeapp.presentation.signin.SignInScreen
import kotlinx.serialization.Serializable

@Serializable
data object SignBaseRoute

@Serializable
data object SignInRoute

fun NavController.navigateToSignIn(navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = SignBaseRoute) {
        popUpTo<IntroRoute> {
            inclusive = true
        }
        navOptions()
    }

fun NavGraphBuilder.signInSection(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    signUpDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<SignBaseRoute>(
        startDestination = SignInRoute,
    ) {
        composable<SignInRoute> {
            SignInScreen(
                email = "",
                password = "",
                onEmailChange = {},
                onPasswordChange = {},
                onForgotPasswordClick = {},
                onSignInClick = onSignInClick,
                loginWithGoogle = {},
                loginWithFacebook = {},
                onSignUpClick = onSignUpClick,
            )
        }
        signUpDestination()
    }
}