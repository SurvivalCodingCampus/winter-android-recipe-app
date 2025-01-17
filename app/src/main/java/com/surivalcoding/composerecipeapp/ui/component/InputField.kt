package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.theme.Black
import com.surivalcoding.composerecipeapp.ui.theme.Gray4
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography
import com.surivalcoding.composerecipeapp.ui.theme.Primary80

@Composable
fun InputField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    isFocused: Boolean = false
) {
    val borderColor = if (isFocused) Primary80 else Gray4
    val textColor = if (value.isNotEmpty()) Black else Gray4

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = PoppinsRegularTypography.bodyMedium,
            color = Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = PoppinsRegularTypography.bodyLarge.copy(
                color = textColor,
                fontSize = 14.sp
            ),
            cursorBrush = SolidColor(Color.Black),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, MaterialTheme.shapes.small)
                        .border(1.5.dp, borderColor, MaterialTheme.shapes.small)
                        .padding(horizontal = 20.dp, vertical = 19.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = PoppinsRegularTypography.bodySmall.copy(color = Gray4)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

@Composable
fun InputFieldExample() {
    val textState = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        // Default
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = textState.value,
            onValueChange = { textState.value = it },
            isFocused = false
        )

        // Focused
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = textState.value,
            onValueChange = { textState.value = it },
            isFocused = true
        )

        // Filled
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = "Filled Text",
            onValueChange = { textState.value = it },
            isFocused = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputFieldPreview() {
    val textState = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        // Default
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = textState.value,
            onValueChange = { textState.value = it },
            isFocused = false
        )

        // Focused
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = textState.value,
            onValueChange = { textState.value = it },
            isFocused = true
        )

        // Filled
        InputField(
            label = "Label",
            placeholder = "Placeholder",
            value = "Filled Text",
            onValueChange = { textState.value = it },
            isFocused = false
        )
    }
}