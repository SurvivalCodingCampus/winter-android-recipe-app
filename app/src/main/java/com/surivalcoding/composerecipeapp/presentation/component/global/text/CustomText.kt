package com.surivalcoding.composerecipeapp.presentation.component.global.text

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = label,
            style = AppTextStyles.regularSmall,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = AppTextStyles.regularSmaller,
                    color = AppColors.LabelWhite
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(size = 10.dp))
                .border(
                    width = 1.5.dp,
                    color = Color(0xFFD9D9D9),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .height(55.dp)
        )
    }
}