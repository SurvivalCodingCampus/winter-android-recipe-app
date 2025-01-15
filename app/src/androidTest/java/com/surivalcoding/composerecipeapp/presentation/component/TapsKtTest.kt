package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import com.surivalcoding.composerecipeapp.ui.AppColors
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class TapsKtTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tap_test() {
        var isClicked = false

        composeTestRule.setContent {
            var insideColorFirst by remember { mutableStateOf(AppColors.primary) }
            var insideColorSecond by remember { mutableStateOf(Color.Transparent) }
            Tabs(
                labels = listOf("first", "second"),
                insideColorFirst = insideColorFirst,
                insideContentSecond = insideColorSecond,
                onValueChangeFirst = {
                    insideColorFirst = AppColors.primary
                    insideColorSecond = Color.Transparent
                    isClicked = true
                },
                onValueChangeSecond = {
                    insideColorFirst = Color.Transparent
                    insideColorSecond = AppColors.primary
                    isClicked = true
                }
            )
        }

        assertTrue(isClicked)
    }
}