package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class SmallButtonKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun smallButton() {
        var isClicked = false

        composeTestRule.setContent {
            SmallButton(
                buttonText = "Small button",
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Small button").performClick()

        assertTrue(isClicked)
    }
}