package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TabsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tabs_should_display_all_labels() {
        composeTestRule.setContent {
            Tabs(
                labels = listOf("First", "Second"),
                selectedIndex = 0,
                onValueChange = {}
            )
        }

        composeTestRule.onNodeWithText("First").assertIsDisplayed()
        composeTestRule.onNodeWithText("Second").assertIsDisplayed()
    }

    @Test
    fun tabs_should_handle_click_and_trigger_onValueChange() {
        var selectedIndex = 0

        composeTestRule.setContent {
            Tabs(
                labels = listOf("First", "Second"),
                selectedIndex = selectedIndex,
                onValueChange = { selectedIndex = it }
            )
        }

        // 두 번째 탭을 클릭
        composeTestRule.onNodeWithText("Second").performClick()

        // selectedIndex가 1로 변경되었는지 확인
        assert(selectedIndex == 1)
    }

    @Test
    fun tabs_should_support_three_items() {
        composeTestRule.setContent {
            Tabs(
                labels = listOf("First", "Second", "Third"),
                selectedIndex = 1,
                onValueChange = {}
            )
        }

        // 세 개의 탭이 모두 표시되는지 확인
        composeTestRule.onNodeWithText("First").assertIsDisplayed()
        composeTestRule.onNodeWithText("Second").assertIsDisplayed()
        composeTestRule.onNodeWithText("Third").assertIsDisplayed()
    }
}