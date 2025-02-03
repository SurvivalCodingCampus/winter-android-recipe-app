package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.surivalcoding.composerecipeapp.common.network.NetworkMonitor
import com.surivalcoding.composerecipeapp.navigation.TopLevelDestination.BOOKMARKS
import com.surivalcoding.composerecipeapp.navigation.TopLevelDestination.HOME
import com.surivalcoding.composerecipeapp.presentation.home.navigation.HomeRoute
import com.surivalcoding.composerecipeapp.presentation.home.navigation.navigateToHome
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation.navigateToSavedRecipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberRecipeState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    networkMonitor: NetworkMonitor,
): RecipeAppState {
    return remember(
        navController,
        coroutineScope,
        networkMonitor
    ) {
        RecipeAppState(
            navController = navController,
            networkMonitor = networkMonitor,
            coroutineScope = coroutineScope
        )
    }
}

class RecipeAppState(
    val navController: NavHostController,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val currentDestinationIsTopLevel: Boolean
        @Composable get() {
            val currentDestination = currentDestination
            return currentDestination?.route?.let { route ->
                TopLevelDestination.entries.any { it.route.java.name == route }
            } == true
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo<HomeRoute> {
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