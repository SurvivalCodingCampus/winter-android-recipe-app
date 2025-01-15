package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class MediumButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mediumButton_should_handle_click_when_enabled() {
        var isClicked = false

        composeTestRule.setContent {
            MediumButton(
                buttonText = "Medium button",
                enabled = true,
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Medium button").apply {
            assertIsEnabled()
            performClick()
        }

        assertTrue(isClicked)
    }

    @Test
    fun mediumButton_should_not_handle_click_when_disabled() {
        var isClicked = false

        composeTestRule.setContent {
            MediumButton(
                buttonText = "Medium button",
                enabled = false,
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Medium button").apply {
            assertIsNotEnabled()
            performClick()
        }

        assertFalse(isClicked)
    }

}