package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class InputFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun inputField_displaysLabelCorrectly() {
        val labelText = "Test Label"

        composeTestRule.setContent {
            InputField(
                label = labelText,
                placeHolder = "Placeholder",
                value = "",
                onValueChange = {}
            )
        }

        composeTestRule.onNodeWithText(labelText).assertIsDisplayed()
    }

    @Test
    fun inputField_displaysPlaceholderWhenEmpty() {
        val placeholderText = "Placeholder"

        composeTestRule.setContent {
            InputField(
                label = "Label",
                placeHolder = placeholderText,
                value = "",
                onValueChange = {}
            )
        }

        composeTestRule.onNodeWithText(placeholderText).assertIsDisplayed()
    }

    @Test
    fun inputField_acceptsTextInput() {
        var inputText = "Hello, World!"

        composeTestRule.setContent {
            InputField(
                label = "Label",
                placeHolder = "Placeholder",
                value = inputText,
                onValueChange = { inputText = it }
            )
        }

        composeTestRule.onNode(hasSetTextAction()).performTextInput(inputText)

        composeTestRule.onNodeWithText(inputText).assertIsDisplayed()
    }
}