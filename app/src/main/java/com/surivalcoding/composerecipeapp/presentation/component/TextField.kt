package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun CraOutlinedTextField(
    value: String,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onValueChange: (text: String) -> Unit,
) {
    val textStyle = MaterialTheme.typography.bodySmall
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(Modifier.height(5.dp))
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
}

@Preview(showBackground = true)
@Composable
private fun CraTextFieldPreview() {
    ComposeRecipeAppTheme {
        CraOutlinedTextField(
            value = "",
            label = "Label",
            onValueChange = {},
            placeholder = "Placeholder"
        )
    }
}