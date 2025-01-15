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
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.presentation.component.SmallButton
import com.surivalcoding.composerecipeapp.presentation.component.Tabs
import com.surivalcoding.composerecipeapp.util.TaskSubmissionForm

@Composable
fun TaskSubmissionButton() {
    TaskSubmissionForm(
        title = "연습문제1: Buttons"
    ) {
        BigButton(
            text = "Button",
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        BigButton(
            text = "Button",
            enabled = false,
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        MediumButton(
            text = "Button",
            onClick = {}
        )
        Spacer(Modifier.height(16.dp))
        SmallButton(
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
        InputField(
            value = value,
            enabled = enabled,
            onValueChange = { text -> value = text },
            label = "Label",
            placeholder = "Placeholder"
        )
        Spacer(Modifier.height(16.dp))
        SmallButton(
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
        val labels = listOf("Topics", "People", "banana")
        Tabs(
            selectedTabIndex = startIdx,
            labels = labels,
            onClickTab = {
                startIdx = it
            }
        )
    }
}