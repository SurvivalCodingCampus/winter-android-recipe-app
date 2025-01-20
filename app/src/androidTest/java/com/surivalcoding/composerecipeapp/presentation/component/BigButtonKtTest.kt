package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class BigButtonKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test_BigButton`() {
        var isClicked by mutableStateOf(false)

        composeTestRule.setContent {
            BigButton(
                title = "Big button",
                onClick = {
                    isClicked = true
                }
            )
        }

        composeTestRule.onNodeWithText("Big button").assertExists()
        composeTestRule.onNodeWithText("Big button").performClick()
        assertTrue(isClicked)
    }
}