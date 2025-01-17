package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.component.CraButton
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun BigButton(
    text: String,
    isPressed: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
) {
    CraButton(
        modifier = modifier
            .wrapContentSize()
            .fillMaxWidth()
            .heightIn(min = 60.dp),
        onClick = onClick,
        isPressed = isPressed,
        enabled = enabled,
        isTrailingIcon = true,
        interactionSource = interactionSource,
    ) {
        Text(
            text = text, style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(min = 114.dp)
        )
    }
}

@Preview
@Composable
private fun BigButtonPreview() {
    ComposeRecipeAppTheme {
        BigButton(
            onClick = {},
            text = "Button",
            enabled = false,
        )
    }
}