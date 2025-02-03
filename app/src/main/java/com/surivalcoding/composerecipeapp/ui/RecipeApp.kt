package com.surivalcoding.composerecipeapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.RecipeNavHost
import com.surivalcoding.composerecipeapp.ui.component.AppBottomBar
import com.surivalcoding.composerecipeapp.ui.theme.AppColors

@Composable
fun RecipeApp(
    appState: RecipeAppState,
    modifier: Modifier = Modifier,
) {
    val currentDestination = appState.currentDestination
    val currentDestinationIsTopLevel = appState.currentDestinationIsTopLevel

    val snackbarHostState = remember { SnackbarHostState() }

    val isOffline by appState.isOffline.collectAsStateWithLifecycle()

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = "인터넷이 연결되어 있지 않습니다",
                duration = Indefinite,
            )
        }
    }

    Scaffold(
        modifier = modifier,
        containerColor = AppColors.White,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(bottom = if (currentDestinationIsTopLevel) 120.dp else 0.dp)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopStart)
            ) {
                RecipeNavHost(
                    appState = appState,
                )
            }
            if (currentDestinationIsTopLevel) {
                AppBottomBar(
                    currentDestination,
                    appState,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
            }
        }
    }
}