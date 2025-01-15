package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun CraButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    isTrailingIcon: Boolean = false,
    text: @Composable () -> Unit,
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
            text()
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
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    CraButton(
        modifier = modifier
            .wrapContentSize()
            .width(174.dp)
            .heightIn(min = 37.dp),
        onClick = onClick,
        enabled = enabled,
        text = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        isTrailingIcon = false
    )
}

@Composable
fun CraMediumButton(
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

@Composable
fun CraBigButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    CraButton(
        modifier = modifier
            .wrapContentSize()
            .width(315.dp)
            .heightIn(min = 60.dp),
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