package com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.SavedRecipeScreen
import kotlinx.serialization.Serializable

@Serializable
data object SavedRecipeRoute

fun NavController.navigateToSavedRecipe(navOptions: NavOptions) =
    navigate(route = SavedRecipeRoute, navOptions = navOptions)

fun NavGraphBuilder.savedRecipeScreen() {
    composable<SavedRecipeRoute> {
        SavedRecipeScreen()
    }
}