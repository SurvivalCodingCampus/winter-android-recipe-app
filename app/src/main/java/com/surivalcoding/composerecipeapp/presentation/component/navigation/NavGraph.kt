package com.surivalcoding.composerecipeapp.presentation.component.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.component.SplashScreen
import com.surivalcoding.composerecipeapp.presentation.component.signIn.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.component.signUp.SignUpScreen

fun NavGraphBuilder.addGraph() {
    composable(route = "SplashScreen") { SplashScreen() }
    composable(route = "SignInScreen") { SignInScreen() }
    composable(route = "SignUpScreen") { SignUpScreen() }
}