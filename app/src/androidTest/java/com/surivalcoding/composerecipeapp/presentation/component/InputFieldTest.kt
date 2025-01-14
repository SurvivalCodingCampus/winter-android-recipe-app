package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class InputFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun InputField_should_show_label_and_placeholder_in_default_state() {
        composeTestRule.setContent {
            InputField(
                label = "Label",
                value = "",
                placeholder = "Placeholder",
                onValueChange = {}
            )
        }

        composeTestRule.onNodeWithText("Label").assertExists()
        composeTestRule.onNodeWithText("Placeholder").assertExists()
    }

    @Test
    fun inputField_should_show_entered_text_and_hide_placeholder_when_text_is_entered() {
        val state = mutableStateOf("")

        composeTestRule.setContent {
            InputField(
                label = "Label",
                value = state.value,
                placeholder = "Placeholder",
                onValueChange = { state.value = it }
            )
        }

        // 초기 상태 확인
        composeTestRule.onNodeWithText("Placeholder").assertExists()

        // 텍스트 입력 상태 변경
        state.value = "Entered Text"

        // 입력된 텍스트가 보이고 placeholder는 숨겨져야 함
        composeTestRule.onNodeWithText("Entered Text").assertExists()
        composeTestRule.onNodeWithText("Placeholder").assertDoesNotExist()
    }

    @Test
    fun inputField_should_handle_focus_state_properly() {
        composeTestRule.setContent {
            InputField(
                label = "Label",
                value = "",
                placeholder = "Placeholder",
                isFocused = true,
                onValueChange = {}
            )
        }

        // 포커스 상태에서도 기본 UI 요소들이 정상적으로 표시되는지 확인
        composeTestRule.onNodeWithText("Label").assertExists()
        composeTestRule.onNodeWithText("Placeholder").assertExists()
    }

    @Test
    fun inputField_should_trigger_onValueChange_when_text_is_entered() {
        var updatedText = ""

        composeTestRule.setContent {
            InputField(
                label = "Label",
                value = updatedText,
                placeholder = "Placeholder",
                onValueChange = { updatedText = it }
            )
        }

        // 텍스트 입력 시뮬레이션
        composeTestRule.onNodeWithText("Placeholder").performTextInput("New Text")

        // onValueChange가 제대로 호출되었는지 확인
        assert(updatedText == "New Text")
    }
}