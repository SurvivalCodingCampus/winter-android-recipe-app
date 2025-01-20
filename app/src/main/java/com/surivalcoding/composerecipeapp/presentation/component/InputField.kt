package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    isFocused: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    var isFieldFocused by remember { mutableStateOf(isFocused) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()  // 높이를 내용에 맞게 조정
            //.padding(vertical = 4.dp)  // 상하 여백 추가
    ) {
        Text(
            text = label,
            modifier = Modifier,

            style = AppTextStyles.smallTextRegular.copy(
                color = AppColors.font
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 55.dp)  // 최소 높이만 지정
                .border(
                    width = 1.5.dp,
                    color = when {
                        isFieldFocused || isFocused -> AppColors.primary80
                        else -> AppColors.gray4
                    },
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 19.dp, vertical = 8.dp)  // 상하 여백 추가
                    .onFocusChanged {
                        isFieldFocused = it.isFocused
                    },
                textStyle = AppTextStyles.smallerTextRegular.copy(
                    color = AppColors.font
                ),
                decorationBox = { innerTextField ->
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = AppTextStyles.smallerTextRegular.copy(
                                    color = AppColors.gray4
                                )
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
private fun DefaultInputFieldPreview() {
    InputField(
        label = "Label",
        value = "",
        placeholder = "Placeholder",
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun FocusedInputFieldPreview() {
    InputField(
        label = "Label",
        value = "",
        placeholder = "Placeholder",
        isFocused = true,  // 포커스 상태 강제
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun FilledInputFieldPreview() {
    InputField(
        label = "Label",
        value = "Placeholder",
        placeholder = "",
        onValueChange = {}
    )
}