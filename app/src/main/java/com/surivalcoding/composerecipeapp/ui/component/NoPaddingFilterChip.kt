package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles

@Composable
fun NoPaddingFilterChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    tailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Surface(
        selected = selected,
        onClick = onClick,
        modifier = modifier
            .semantics { role = Role.Checkbox },
        shape = RoundedCornerShape(10.dp),
        color = if (selected) AppColors.Primary100 else AppColors.White,
        border = BorderStroke(
            1.dp,
            if (selected) AppColors.White else AppColors.Primary100
        ),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Box(
                Modifier
                    .padding(
                        start = if (leadingIcon != null) 5.dp else 0.dp,
                        end = if (tailingIcon != null) 5.dp else 0.dp,
                    ),
            ) {
                Text(
                    text = label,
                    style = AppTextStyles.smallTextRegular,
                    modifier = Modifier.padding(0.dp),
                    color = if (selected) AppColors.White else AppColors.Primary100
                )
            }
            if (tailingIcon != null) {
                tailingIcon()
            }
        }
    }
}