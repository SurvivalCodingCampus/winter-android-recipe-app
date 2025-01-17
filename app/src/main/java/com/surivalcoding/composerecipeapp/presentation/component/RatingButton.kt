package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.component.NoPaddingFilterChip
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun RatingButton(
    rating: Int,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NoPaddingFilterChip(
        label = "$rating",
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        tailingIcon = {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = CraIcons.star,
                tint = if (selected) AppColors.White else AppColors.Primary80,
                contentDescription = null
            )
        }
    )
}

@Preview
@Composable
fun RatingButtonPreview() {
    ComposeRecipeAppTheme {
        RatingButton(
            selected = true,
            rating = 5,
            onClick = {},
        )
    }
}