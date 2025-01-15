package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    label: String,
    onValueChange: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Label 텍스트
        Text(
            text = label,
            style = AppTextStyles.smallTextRegular,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        // TextField 입력 필드
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it) },
            placeholder = {
                Text(
                    text = placeholder,
                    style = AppTextStyles.smallTextRegular,
                    color = Color.Gray
                )
            },
            colors = OutlinedTextFieldDefaults.colors(     //처음에는 if문으로 빈값일 때 아닐 때를 구분했는데 여기서 한번에 처리가 가능했다.
                  focusedPlaceholderColor = Color.Gray,
                  unfocusedPlaceholderColor = Color.Gray,
                  focusedTextColor = Color.Black,
                  unfocusedTextColor = Color.Black,
                  focusedBorderColor = AppColors.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            textStyle = AppTextStyles.smallTextRegular,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldEmptyPreview() {
    InputField(
        placeholder = "Placeholder",
        label = "Label",
        text = "",
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun InputFieldCursorPreview() {
    InputField(
        placeholder = "Placeholder",
        label = "Label",
        text = "",
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun InputFieldFilledPreview() {
    InputField(
        placeholder = "Placeholder",
        label = "Label",
        text = "Placeholder",
        onValueChange = {}
    )
}