package com.surivalcoding.composerecipeapp

import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.surivalcoding.composerecipeapp.presentation.component.CraButton
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class CraButtonTest() {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_cra_button_click() {
        var isClicked = false
        composeTestRule.setContent {
            CraButton(
                onClick = { isClicked = true }
            ) {
                Text(text = "Button")
            }
        }

        composeTestRule
            .onNodeWithText("Button")
            .assertExists()
            .performClick()

        assertTrue(isClicked)
    }
}