package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.navigation.RecipeApp
import com.surivalcoding.composerecipeapp.navigation.RecipeAppState
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRecipeAppTheme {
                val appState = RecipeAppState(
                    navController = rememberNavController()
                )
                RecipeApp(
                    appState = appState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

