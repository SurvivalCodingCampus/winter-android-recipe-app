package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.surivalcoding.composerecipeapp.navigation.TopLevelDestination.BOOKMARKS
import com.surivalcoding.composerecipeapp.navigation.TopLevelDestination.HOME
import com.surivalcoding.composerecipeapp.presentation.home.navigation.navigateToHome
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation.navigateToSavedRecipe

class RecipeAppState(
    val navController: NavHostController
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            // Collect the currentBackStackEntryFlow as a state
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val currentDestinationIsTopLevel: Boolean
        @Composable get() {
            val currentDestination = currentDestination // currentDestination은 위 코드에서 정의된 값

            // 현재 destination의 route가 TopLevelDestination의 route와 일치하는지 확인
            return currentDestination?.route?.let { route ->
                TopLevelDestination.entries.any { it.route.java.name == route }
            } == true
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            HOME -> navController.navigateToHome(topLevelNavOptions)
            BOOKMARKS -> navController.navigateToSavedRecipe(topLevelNavOptions)
        }
    }
}