package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun CraButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    isTrailingIcon: Boolean,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier
                .widthIn(min = 114.dp)
                .padding(
                    end = if (isTrailingIcon) {
                        ButtonDefaults.IconSpacing
                    } else {
                        0.dp
                    },
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
            )
        }
        if (isTrailingIcon) {
            Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
                Icon(
                    imageVector = CraIcons.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun CraSmallButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    text: String,
) {
    CraButton(
        modifier = modifier
            .width(174.dp)
            .height(37.dp),
        onClick = onClick,
        enabled = enabled,
        text = text,
        isTrailingIcon = false
    )
}

@Composable
fun CraMediumButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    text: String,
) {
    CraButton(
        modifier = modifier
            .width(243.dp)
            .height(54.dp),
        onClick = onClick,
        enabled = enabled,
        text = text,
        isTrailingIcon = true
    )
}

@Composable
fun CraBigButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    text: String,
) {
    CraButton(
        modifier = modifier
            .width(315.dp)
            .height(60.dp),
        onClick = onClick,
        enabled = enabled,
        text = text,
        isTrailingIcon = true
    )
}


@Preview
@Composable
private fun CrSmallButtonPreview() {
    ComposeRecipeAppTheme {
        CraSmallButton(
            onClick = {},
            text = "Button",
        )
    }
}

@Preview
@Composable
private fun CrMediumButtonPreview() {
    ComposeRecipeAppTheme {
        CraMediumButton(
            onClick = {},
            text = "Button",
        )
    }
}

@Preview
@Composable
private fun CrBigButtonPreview() {
    ComposeRecipeAppTheme {
        CraBigButton(
            onClick = {},
            text = "Button",
            enabled = false,
        )
    }
}