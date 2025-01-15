package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MediumButtonKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test_MediumButton`() {
        var isClicked = false

        composeTestRule.setContent {
            MediumButton(
                text = "Medium button",
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Medium button").performClick()

        assertTrue(isClicked)
    }
}