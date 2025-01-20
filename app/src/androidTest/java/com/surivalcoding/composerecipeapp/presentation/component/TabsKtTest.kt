package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.surivalcoding.composerecipeapp.ui.AppColors
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class TabsKtTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tap_test() {
        var index by mutableStateOf(-1)

        composeTestRule.setContent {
            Tabs(
                labels = listOf("First", "Second"),
                selectedIndex = 0,
                onValueChange = { value ->
                    index = value
                }
            )
        }

        composeTestRule.onNodeWithTag("testTag 1").performClick()

        assertEquals(1, index)
    }
}