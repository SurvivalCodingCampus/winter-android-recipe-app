package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    typing: String,
    borderColor: Color,
    onValueChange: (String) -> Unit = {},
    onFocusChanged: (FocusState) -> Unit = {}
) {
    Box(
        modifier = modifier
            .width(315.dp)
            .height(81.dp)
    ) {
        Column(
        ) {
            Box() {
                Text(text = title)
            }
            Spacer(Modifier.height(8.dp))
            TextField(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .border(1.5.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
                    .onFocusChanged(onFocusChanged),
                value = typing,
                onValueChange = onValueChange,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = AppColors.gray_04,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text(text = placeholder, color = AppColors.gray_04) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPreview() {
    makeInputField(title = "hello", placeholder = "hello")
}

@Composable
fun makeInputField(title: String, placeholder: String) {
    var typing by remember { mutableStateOf("") }
    var borderColor by remember { mutableStateOf(Color.Gray) }
    InputField(
        title = title,
        placeholder = placeholder,
        typing = typing,
        borderColor = borderColor,
        onValueChange = { newText -> typing = newText },
        onFocusChanged = { onFocusState ->
            if(onFocusState.isFocused) {
                borderColor = AppColors.primary
            } else {
                borderColor = Color.Gray
            }
        }
    )
}