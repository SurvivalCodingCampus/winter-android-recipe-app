package com.surivalcoding.composerecipeapp.presentation.component

import AppColors
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    placeHolder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column {
        Text(
            label,
            style = AppTextStyles.normalTextRegular
        )
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            modifier = modifier
                .width(315.dp)
                .height(55.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = AppColors.gray4,
                focusedBorderColor = AppColors.primary80

            ),
            textStyle = TextStyle(color = Color.Black, fontSize = 11.sp),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    placeHolder,
                    fontSize = 11.sp,
                    color = AppColors.gray4
                )
            },
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPreview() {
    InputField(
        label = "Label",
        placeHolder = "Placeholder",
        value = "Placeholder",
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPreview2() {
    InputField(
        label = "Label",
        placeHolder = "Placeholder",
        value = "",
        onValueChange = {}
    )
}