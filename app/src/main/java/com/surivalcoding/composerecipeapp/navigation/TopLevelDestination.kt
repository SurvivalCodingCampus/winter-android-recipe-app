package com.surivalcoding.composerecipeapp.navigation

import androidx.annotation.DrawableRes
import com.surivalcoding.composerecipeapp.presentation.home.navigation.HomeBaseRoute
import com.surivalcoding.composerecipeapp.presentation.home.navigation.HomeRoute
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation.SavedRecipeRoute
import com.surivalcoding.composerecipeapp.ui.CraIcons
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @DrawableRes
    val icon: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        icon = CraIcons.outlinedHome,
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class
    ),
    BOOKMARKS(
        icon = CraIcons.bookMark,
        route = SavedRecipeRoute::class,
    )
}