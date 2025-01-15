package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    containerColor: Color = MaterialTheme.colorScheme.primary,
    isTrailingIcon: Boolean = false,
    text: @Composable () -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
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

@Preview
@Composable
private fun CrSmallButtonPreview() {
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