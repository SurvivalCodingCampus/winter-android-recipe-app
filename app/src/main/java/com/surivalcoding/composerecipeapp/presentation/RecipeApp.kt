package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.runtime.Composable
import com.surivalcoding.composerecipeapp.presentation.navigation.NavigationRoot

@Composable
fun RecipeApp() {
    val appState = rememberAppState()
    NavigationRoot(appState)
}