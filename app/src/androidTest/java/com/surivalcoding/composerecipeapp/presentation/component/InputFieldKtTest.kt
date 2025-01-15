package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.surivalcoding.composerecipeapp.ui.AppColors
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class InputFieldKtTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkInputField() {
        composeTestRule.setContent {
            var backgroundColorChanged = false

            var text by remember { mutableStateOf("placeholder") }
            var borderColor by remember { mutableStateOf(Color.Gray) }
            InputField(
                modifier = Modifier
                    .testTag("testInputField"),
                text = text,
                borderColor = borderColor,
                onValueChange = { newText -> text = newText },
                onFocusChanged = { onFocusState ->
                    if(onFocusState.isFocused) {
                        borderColor = AppColors.primary
                        backgroundColorChanged = true
                    } else {
                        borderColor = Color.Gray
                    }
                }
            )

            composeTestRule.onNodeWithTag("testInputField")
                .performClick()

            assertTrue(backgroundColorChanged)
        }
    }
}