package com.surivalcoding.composerecipeapp.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.presentation.component.BottomNavigationBar
import com.surivalcoding.composerecipeapp.presentation.main.home.HomeScreen
import com.surivalcoding.composerecipeapp.presentation.main.home.HomeViewModel
import com.surivalcoding.composerecipeapp.presentation.navigation.BottomNavItem
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
                val state by viewModel.state.collectAsStateWithLifecycle()
                HomeScreen(state = state, onSearchClick = {})
            }

            composable(BottomNavItem.SavedRecipes.route) {
                val viewModel: SavedRecipesViewModel =
                    viewModel(factory = SavedRecipesViewModel.Factory)
                val state by viewModel.state.collectAsStateWithLifecycle()
                SavedRecipeScreen(state = state, onBookmarkClick = viewModel::onBookmarkClick)
            }

            composable(BottomNavItem.RecipeWrite.route) {
                // TODO: Implement later
            }
            composable(BottomNavItem.Notification.route) {
                // TODO: Implement later
            }
            composable(BottomNavItem.Profile.route) {
                // TODO: Implement later
            }
        }
    }
}