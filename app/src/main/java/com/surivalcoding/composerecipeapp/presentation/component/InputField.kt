package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun InputField(
    value: String,
    label: String,
    placeholder: String,
    onValueChange: (text: String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            style = AppTextStyles.smallTextRegular,
        )
        Spacer(Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            textStyle = AppTextStyles.smallerTextRegular,
            placeholder = {
                Text(
                    text = placeholder,
                    style = AppTextStyles.smallerTextRegular,
                )
            },
            visualTransformation = visualTransformation,
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
private fun InputFieldPreview() {
    ComposeRecipeAppTheme {
        InputField(
            value = "",
            label = "Label",
            onValueChange = {},
            placeholder = "Placeholder"
        )
    }
}