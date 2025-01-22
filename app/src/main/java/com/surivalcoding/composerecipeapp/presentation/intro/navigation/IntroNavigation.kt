package com.surivalcoding.composerecipeapp.presentation.intro.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.intro.IntroScreen
import kotlinx.serialization.Serializable

@Serializable
data object IntroRoute

fun NavGraphBuilder.introScreen(
    onStartClick: () -> Unit,
) {
    composable<IntroRoute> {
        IntroScreen(
            onClickStart = onStartClick,
        )
    }
}
