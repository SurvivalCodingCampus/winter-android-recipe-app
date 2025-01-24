package com.surivalcoding.composerecipeapp.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.surivalcoding.composerecipeapp.data.mock.fakeHomeRecipes
import com.surivalcoding.composerecipeapp.data.mock.fakeNewRecipes
import com.surivalcoding.composerecipeapp.presentation.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeBaseRoute

@Serializable
data object HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) =
    navigate(route = HomeBaseRoute, navOptions = navOptions)

fun NavGraphBuilder.homeScreen(
    onSearchClick: () -> Unit,
    searchRecipeDestination: () -> Unit,
) {
    navigation<HomeBaseRoute>(
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                homeRecipes = fakeHomeRecipes,
                newRecipes = fakeNewRecipes,
                onSearchClick = onSearchClick
            )
        }
        searchRecipeDestination()
    }
}