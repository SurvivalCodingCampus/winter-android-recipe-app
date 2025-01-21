package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun BasicField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    placeholder: String,
    onValueChange: (String) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth())
    {
        Text(
            text = label,
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = 14.sp,
                color = AppColors.label_color
            )
        )

        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            textStyle = AppTextStyles.smallTextRegular.copy(
                color = AppColors.black
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray_4
                    )
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppColors.primary_80,
                unfocusedBorderColor = AppColors.gray_4,
                cursorColor = AppColors.gray_1
            ),
            shape = RoundedCornerShape(10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column {
        BasicField(value = "", label = "Label", placeholder = "Placeholder")
        Spacer(Modifier.height(30.dp))
        BasicField(value = "", label = "Label", placeholder = "Placeholder")
        Spacer(Modifier.height(30.dp))
        BasicField(value = "Placeholder", label = "Label", placeholder = "Placeholder")
    }

}
