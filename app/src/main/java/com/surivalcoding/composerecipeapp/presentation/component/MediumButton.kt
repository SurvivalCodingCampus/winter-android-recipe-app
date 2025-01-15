package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.component.CraButton
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun MediumButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    CraButton(
        modifier = modifier
            .wrapContentSize()
            .width(243.dp)
            .heightIn(min = 54.dp),
        onClick = onClick,
        enabled = enabled,
        text = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        isTrailingIcon = true
    )
}

@Preview
@Composable
private fun MediumButtonPreview() {
    ComposeRecipeAppTheme {
        MediumButton(
            onClick = {},
            text = "Button",
        )
    }
}