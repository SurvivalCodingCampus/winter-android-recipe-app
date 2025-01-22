package com.surivalcoding.composerecipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.surivalcoding.composerecipeapp.ui.component.InputField
import org.junit.Rule
import org.junit.Test

class InputFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_InputField_Input() {
        val inputText = mutableStateOf("")

        composeTestRule.setContent {
            InputField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                placeholder = "Enter text",
                enabled = true,
                label = "Label"
            )
        }

        composeTestRule.onNodeWithText("Enter text").assertExists()

        val testInput = "Hello World"
        composeTestRule.onNodeWithText("Enter text").performTextInput(testInput)

        // text update 확인
        composeTestRule.onNodeWithText(testInput).assertTextEquals(testInput)
    }
}
