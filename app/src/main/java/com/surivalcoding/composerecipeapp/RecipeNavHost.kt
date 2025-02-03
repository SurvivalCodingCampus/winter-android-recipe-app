package com.surivalcoding.composerecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.surivalcoding.composerecipeapp.presentation.home.navigation.homeScreen
import com.surivalcoding.composerecipeapp.presentation.home.navigation.navigateToHome
import com.surivalcoding.composerecipeapp.presentation.intro.navigation.IntroRoute
import com.surivalcoding.composerecipeapp.presentation.intro.navigation.introScreen
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation.savedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.navigation.navigateToSearchRecipe
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.navigation.searchRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.signin.navigation.SignBaseRoute
import com.surivalcoding.composerecipeapp.presentation.signin.navigation.navigateToSignIn
import com.surivalcoding.composerecipeapp.presentation.signin.navigation.signInSection
import com.surivalcoding.composerecipeapp.presentation.signup.navigation.navigateToSignUp
import com.surivalcoding.composerecipeapp.presentation.signup.navigation.signUpScreen
import com.surivalcoding.composerecipeapp.ui.RecipeAppState

@Composable
fun RecipeNavHost(
    appState: RecipeAppState,
    modifier: Modifier = Modifier
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = IntroRoute,
        modifier = modifier
    ) {
        introScreen(
            onStartClick = navController::navigateToSignIn
        )
        signInSection(
            onSignInClick = {
                navController.navigateToHome(navOptions {
                    popUpTo<SignBaseRoute> {
                        inclusive = true
                    }
                })
            },
            onSignUpClick = navController::navigateToSignUp,
        ) {
            signUpScreen(
                onSignInClick = navController::popBackStack,
            )
        }
        homeScreen(
            onSearchClick = navController::navigateToSearchRecipe
        ) {
            searchRecipeScreen()
        }
        savedRecipeScreen()
    }
}