package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun CraOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    enabled: Boolean = true,
    placeholder: String,
    onValueChange: (text: String) -> Unit,
) {
    val textStyle = MaterialTheme.typography.bodySmall.copy(
        fontSize = 11.sp,
        lineHeight = 16.5.sp,
    )
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        textStyle = textStyle,
        placeholder = {
            Text(
                text = placeholder,
                style = textStyle,
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedPlaceholderColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledBorderColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledTextColor = MaterialTheme.colorScheme.surface,
            disabledPlaceholderColor = MaterialTheme.colorScheme.surface,
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CraTextFieldPreview() {
    ComposeRecipeAppTheme {
        CraOutlinedTextField(
            modifier = Modifier.padding(20.dp),
            value = "",
            onValueChange = {},
            placeholder = "Placeholder"
        )
    }
}