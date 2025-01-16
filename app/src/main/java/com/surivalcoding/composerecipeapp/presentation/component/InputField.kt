package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }
    var textValue by remember { mutableStateOf(value) }

    // 값이 변경될 때 textValue 업데이트
    textValue = value

    Box(
        modifier = modifier
            .width(315.dp)
            .height(81.dp)
    ) {
        Column {
            Text(
                text = label,
                fontSize = 14.sp,
                style = AppTextStyles.smallerTextRegular.copy(
                    color = AppColors.font,
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            BasicTextField(
                value = textValue,
                onValueChange = { newText ->
                    textValue = newText
                    onValueChange(newText)
                },
                textStyle = TextStyle(fontSize = 11.sp, color = Color.Black), // 입력 텍스트 색상 설정
                modifier = Modifier
                    .width(315.dp)
                    .height(55.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        width = 1.5.dp,
                        color = if (isFocused) AppColors.primary80 else AppColors.gray4,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 20.dp)
                    .onFocusChanged {
                        isFocused = it.isFocused
                    },
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (textValue.isBlank()) {
                            Text(
                                text = placeholder,
                                fontSize = 11.sp,
                                color = AppColors.gray4,
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LabelInputFieldPreview() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            InputField(
                label = "Label",
                placeholder = "Placeholder",
                value = "",
                onValueChange = { text1 = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputField(
                label = "Label",
                placeholder = "Placeholder",
                value = text1,
                onValueChange = { text1 = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputField(
                label = "Label",
                placeholder = "Placeholder",
                value = text2,
                onValueChange = { text2 = it },
            )
        }
    }

}