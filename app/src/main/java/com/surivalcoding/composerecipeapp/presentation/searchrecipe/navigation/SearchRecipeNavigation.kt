package com.surivalcoding.composerecipeapp.presentation.searchrecipe.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchRecipeScreen
import kotlinx.serialization.Serializable

@Serializable
data object SearchRecipeRoute

fun NavController.navigateToSearchRecipe(navOptions: NavOptions? = null) =
    navigate(route = SearchRecipeRoute, navOptions = navOptions)

fun NavGraphBuilder.searchRecipeScreen() {
    composable<SearchRecipeRoute> {
        SearchRecipeScreen()
    }
}