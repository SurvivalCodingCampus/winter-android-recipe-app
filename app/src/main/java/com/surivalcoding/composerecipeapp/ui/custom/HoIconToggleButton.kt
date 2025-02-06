package com.surivalcoding.composerecipeapp.ui.custom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.icon.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun HoIconToggleButton(
    icon: @Composable () -> Unit,
    checkedIcon: @Composable () -> Unit,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean = false
) {
    val containerColor = if (checked) AppColors.Primary80 else AppColors.White
    val contentColor = if (checked) AppColors.White else AppColors.Primary80
    NoPaddingButton(
        onClick = onCheckedChange,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier,
    ) {
        if (checked) checkedIcon() else icon()
    }
}

@Preview
@Composable
private fun IconToggleButtonPreview() {
    ComposeRecipeAppTheme {
        HoIconToggleButton(
            icon = {
                Icon(
                    painter = painterResource(AppIcons.outlinedHome),
                    contentDescription = null,
                )
            },
            checkedIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.outlinedBookMark),
                    contentDescription = null
                )
            },
            onCheckedChange = { },
            checked = false
        )
    }
}