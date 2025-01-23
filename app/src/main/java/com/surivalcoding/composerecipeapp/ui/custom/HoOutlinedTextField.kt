package com.surivalcoding.composerecipeapp.ui.custom

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun HoOutlinedTextField(
    value: String,
    enabled: Boolean = true,
    placeholder: @Composable () -> Unit = {},
    textStyle: TextStyle = TextStyle.Default,
    onValueChange: (String) -> Unit,
    prefix: @Composable (() -> Unit)? = null,
    borderColor: Color,
    borderWidth: Dp = 1.dp,
    shape: Shape = RoundedCornerShape(8.dp),
    singleLine: Boolean = false,
    innerPadding: PaddingValues = PaddingValues(16.dp),
    interactionSource: MutableInteractionSource? = null,
    modifier: Modifier = Modifier
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    CompositionLocalProvider(
        LocalTextStyle provides textStyle,
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            interactionSource = interactionSource,
            singleLine = singleLine,
            decorationBox = { innerTextField ->
                DecorationBox(
                    value = value,
                    placeholder = placeholder,
                    textField = innerTextField,
                    prefix = prefix,
                    enabled = enabled,
                    borderColor = borderColor,
                    borderWidth = borderWidth,
                    shape = shape,
                    interactionSource = interactionSource,
                    innerPadding = innerPadding,
                )
            },
            modifier = modifier
        )
    }
}

@Composable
fun DecorationBox(
    value: String,
    placeholder: @Composable () -> Unit,
    textField: @Composable (() -> Unit),
    prefix: @Composable (() -> Unit)? = null,
    enabled: Boolean,
    innerPadding: PaddingValues,
    borderColor: Color,
    borderWidth: Dp,
    shape: Shape,
    interactionSource: InteractionSource,
    modifier: Modifier = Modifier
) {
    val focused = interactionSource.collectIsFocusedAsState().value
    val stroke = animateBorderStrokeAsState(
        color = if (focused) borderColor else AppColors.Gray4,
        enabled = enabled,
        focused = focused,
        focusedBorderThickness = borderWidth,
        unfocusedBorderThickness = borderWidth
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(stroke.value, shape)
            .padding(innerPadding)
    ) {
        if (prefix != null) {
            prefix()
        }
        if (value.isBlank()) {
            placeholder()
        } else {
            textField()
        }
    }
}

@Composable
internal fun animateBorderStrokeAsState(
    color: Color,
    enabled: Boolean = true,
    focused: Boolean,
    focusedBorderThickness: Dp,
    unfocusedBorderThickness: Dp
): State<BorderStroke> {
    val targetColor = color
    val indicatorColor =
        if (enabled) {
            animateColorAsState(targetColor, tween(durationMillis = 150))
        } else {
            rememberUpdatedState(targetColor)
        }

    val thickness =
        if (enabled) {
            val targetThickness = if (focused) focusedBorderThickness else unfocusedBorderThickness
            animateDpAsState(targetThickness, tween(durationMillis = 150))
        } else {
            rememberUpdatedState(unfocusedBorderThickness)
        }

    return rememberUpdatedState(BorderStroke(thickness.value, indicatorColor.value))
}

@Preview(showBackground = true)
@Composable
private fun HoOutlinedTextFieldPreview() {
    ComposeRecipeAppTheme {
        HoOutlinedTextField(
            value = "",
            textStyle = AppTextStyles.smallerTextRegular.copy(
                color = AppColors.Primary100
            ),
            placeholder = {
                Text(
                    text = "Search recipe",
                    color = AppColors.Gray4,
                )
            },
            prefix = {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.searchNormal),
                    contentDescription = null,
                    tint = AppColors.Gray4,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(18.dp)
                )
            },
            borderColor = AppColors.Primary100,
            borderWidth = 1.3.dp,
            shape = RoundedCornerShape(10.dp),
            innerPadding = PaddingValues(horizontal = 10.dp, vertical = 11.dp),
            onValueChange = {}
        )
    }
}