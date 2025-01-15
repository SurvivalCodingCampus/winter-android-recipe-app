package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class SmallButtonKtTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun button_callback_test() {
        var callbackExecuted = false

        composeTestRule.setContent {
            SmallButton(modifier = Modifier, "Good Button", onClick = { callbackExecuted = true })
        }

        composeTestRule
            .onNodeWithText("Good Button")
            .performClick()

        assertTrue(callbackExecuted)
    }
}