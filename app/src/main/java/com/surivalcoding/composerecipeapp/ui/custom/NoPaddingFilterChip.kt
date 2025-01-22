package com.surivalcoding.composerecipeapp.ui.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles

@Composable
fun NoPaddingFilterChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    textStyle: TextStyle = AppTextStyles.smallerTextRegular,
    selectedColor: Color = AppColors.Primary100,
    unSelectedColor: Color = AppColors.Primary100,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides Dp.Unspecified) {
        Surface(
            selected = selected,
            onClick = onClick,
            color = if (selected) selectedColor else AppColors.White,
            contentColor = if (selected) AppColors.White else unSelectedColor,
            modifier = modifier
                .semantics { role = Role.Checkbox },
            border = BorderStroke(
                1.dp,
                if (selected) AppColors.White else AppColors.Primary80
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(contentPadding)
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                }
                Box(
                    Modifier
                        .padding(
                            start = if (leadingIcon != null) 5.dp else 0.dp,
                            end = if (trailingIcon != null) 5.dp else 0.dp,
                        ),
                ) {
                    Text(
                        text = label,
                        style = textStyle,
                        modifier = Modifier.padding(0.dp),
                    )
                }
                if (trailingIcon != null) {
                    trailingIcon()
                }
            }
        }
    }
}