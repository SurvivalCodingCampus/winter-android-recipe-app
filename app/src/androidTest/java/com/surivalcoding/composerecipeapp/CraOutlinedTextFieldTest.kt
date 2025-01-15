package com.surivalcoding.composerecipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.surivalcoding.composerecipeapp.presentation.component.CraOutlinedTextField
import org.junit.Rule
import org.junit.Test

class CraOutlinedTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCraOutlinedTextFieldInput() {
        val inputText = mutableStateOf("")

        composeTestRule.setContent {
            CraOutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                placeholder = "Enter text",
                enabled = true
            )
        }

        composeTestRule.onNodeWithText("Enter text").assertExists()

        val testInput = "Hello World"
        composeTestRule.onNodeWithText("Enter text").performTextInput(testInput)

        // text update 확인
        composeTestRule.onNodeWithText(testInput).assertTextEquals(testInput)
    }
}
