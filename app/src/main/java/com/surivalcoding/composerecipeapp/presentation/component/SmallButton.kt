package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
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
fun SmallButton(
    text: String,
    onClick: () -> Unit,
    isPressed: Boolean = false,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
) {
    CraButton(
        modifier = modifier
            .wrapContentSize()
            .width(174.dp)
            .heightIn(min = 37.dp),
        onClick = onClick,
        isPressed = isPressed,
        enabled = enabled,
        isTrailingIcon = false,
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(min = 114.dp)
        )
    }
}

@Preview
@Composable
private fun SmallButtonPreview() {
    ComposeRecipeAppTheme {
        SmallButton(
            onClick = {},
            text = "Button",
        )
    }
}