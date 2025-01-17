package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun CraButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isPressed: Boolean = false,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    containerColor: Color = AppColors.Primary100,
    isTrailingIcon: Boolean = false,
    interactionSource: MutableInteractionSource? = null,
    text: @Composable () -> Unit,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }

    Button(
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) {
                AppColors.Gray4
            } else {
                containerColor
            },
            disabledContainerColor = AppColors.Gray4,
            disabledContentColor = AppColors.White,
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier
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

@Preview
@Composable
private fun CraButtonPreview() {
    ComposeRecipeAppTheme {
        CraButton(
            onClick = {},
            text = {
                Text(
                    text = "Button",
                    style = MaterialTheme.typography.bodySmall
                )
            },
        )
    }
}