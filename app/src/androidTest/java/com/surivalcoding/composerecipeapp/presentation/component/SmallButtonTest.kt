package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class SmallButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun smallButton_should_handle_click_when_enabled() {
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

    @Test
    fun smallButton_should_not_handle_click_when_disabled() {
        var isClicked = false

        composeTestRule.setContent {
            SmallButton(
                buttonText = "Small button",
                enabled = false,
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Small button").apply {
            assertIsNotEnabled()
            performClick()
        }

        assertFalse(isClicked)
    }

}