package com.surivalcoding.composerecipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.surivalcoding.composerecipeapp.presentation.component.CraTab
import com.surivalcoding.composerecipeapp.presentation.component.CraTabRow
import org.junit.Rule
import org.junit.Test

class CraTabRowTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCraTabRowDisplaysTabs() {
        val selectedTabIndex = mutableStateOf(0)
        val titles = listOf("Home", "Profile", "Settings")

        composeTestRule.setContent {
            CraTabRow {
                titles.forEachIndexed { index, title ->
                    CraTab(
                        selected = selectedTabIndex.value == index,
                        onClick = { selectedTabIndex.value = index },
                        title = title
                    )
                }
            }
        }

        titles.forEach { title ->
            composeTestRule.onNodeWithText(title).assertExists()
        }
    }

    @Test
    fun testCraTabSelectionChangesColor() {
        val selectedTabIndex = mutableStateOf(0)
        val titles = listOf("Tab1", "Tab2", "Tab3")

        composeTestRule.setContent {
            CraTabRow {
                titles.forEachIndexed { index, title ->
                    CraTab(
                        selected = selectedTabIndex.value == index,
                        onClick = { selectedTabIndex.value = index },
                        title = title
                    )
                }
            }
        }

        composeTestRule.onNodeWithText("Tab1").assertExists().assertIsSelected()
        composeTestRule.onNodeWithText("Tab2").assertExists().assertIsNotSelected()

        composeTestRule.onNodeWithText("Tab2").performClick()

        composeTestRule.onNodeWithText("Tab1").assertIsNotSelected()
        composeTestRule.onNodeWithText("Tab2").assertIsSelected()
    }
}
