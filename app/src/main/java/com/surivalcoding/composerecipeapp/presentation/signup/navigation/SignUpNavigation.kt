package com.surivalcoding.composerecipeapp.presentation.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.signup.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object SignUpRoute

fun NavController.navigateToSignUp(navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = SignUpRoute) {
        navOptions()
    }

fun NavGraphBuilder.signUpScreen(
    onSignInClick: () -> Unit,
) {
    composable<SignUpRoute> {
        SignUpScreen(
            name = "",
            email = "",
            password = "",
            confirmPassword = "",
            checkedTerms = true,
            onCheckedTermsChange = {},
            onSignInClick = onSignInClick,
            loginWithGoogle = {},
            loginWithFacebook = {},
            onEmailChange = {},
            onPasswordChange = {},
            onNameChange = {},
            onConfirmPasswordChange = {},
        )
    }
}