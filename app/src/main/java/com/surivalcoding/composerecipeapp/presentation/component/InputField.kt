package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.isFocused
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    text: String,
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
                Text("Label")
            }
            Spacer(Modifier.height(8.dp))
            TextField(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .border(1.5.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
                    .onFocusChanged(onFocusChanged),
                value = text,
                onValueChange = onValueChange,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedTextColor = AppColors.gray,
                    focusedContainerColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPreview() {
    var text by remember { mutableStateOf("placeholder") }
    var borderColor by remember { mutableStateOf(Color.Gray) }
    InputField(
        text = text,
        borderColor = borderColor,
        onValueChange = { newText -> text = newText },
        onFocusChanged = { onFocusState ->
            if(onFocusState.isFocused) {
                borderColor = AppColors.primary
            } else {
                borderColor = Color.Gray
            }
        }
    )
}