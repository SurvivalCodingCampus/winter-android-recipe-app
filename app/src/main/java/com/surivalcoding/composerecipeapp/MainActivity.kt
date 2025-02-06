package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.surivalcoding.composerecipeapp.common.network.NetworkMonitor
import com.surivalcoding.composerecipeapp.ui.RecipeApp
import com.surivalcoding.composerecipeapp.ui.rememberRecipeState
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRecipeAppTheme {
                val appState = rememberRecipeState(
                    networkMonitor = networkMonitor,
                )
                RecipeApp(
                    appState = appState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

