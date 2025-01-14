package com.surivalcoding.composerecipeapp.task.day1

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.CraBigButton
import com.surivalcoding.composerecipeapp.presentation.component.CraMediumButton
import com.surivalcoding.composerecipeapp.presentation.component.CraOutlinedTextField
import com.surivalcoding.composerecipeapp.presentation.component.CraSmallButton
import com.surivalcoding.composerecipeapp.presentation.component.CraTab
import com.surivalcoding.composerecipeapp.presentation.component.CraTabRow
import com.surivalcoding.composerecipeapp.util.TaskSubmissionForm

@Composable
fun TaskSubmissionButton() {
    TaskSubmissionForm(
        title = "연습문제1: Buttons"
    ) {
        CraBigButton(
            text = "Button",
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        CraBigButton(
            text = "Button",
            enabled = false,
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        CraMediumButton(
            text = "Button",
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        CraSmallButton(
            text = "Button",
            onClick = {}
        )
    }
}

@Composable
fun TaskSubmissionTextField() {
    TaskSubmissionForm(
        title = "연습문제2: InputField"
    ) {
        var value by remember { mutableStateOf("") }
        var enabled by remember { mutableStateOf(true) }
        CraOutlinedTextField(
            value = value,
            enabled = enabled,
            onValueChange = { text -> value = text },
            placeholder = "Placeholder"
        )
        Spacer(Modifier.height(16.dp))
        CraSmallButton(
            text = "Set Disabled",
            onClick = { enabled = !enabled }
        )
    }
}

@Composable
fun TaskSubmissionTags() {
    TaskSubmissionForm(
        title = "연습문제3: Tabs"
    ) {
        var startIdx by remember { mutableIntStateOf(0) }
        val titles = listOf("Topics", "People", "banana")
        CraTabRow {
            titles.forEachIndexed { index, title ->
                CraTab(
                    selected = startIdx == index,
                    onClick = { startIdx = index },
                    title = title,
                )
            }
        }
    }
}