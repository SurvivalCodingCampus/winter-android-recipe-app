package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.composerecipeapp.ui.component.NoPaddingFilterChip
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun FilterButton(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NoPaddingFilterChip(
        label = label,
        selected = selected,
        onClick = onClick,
        modifier = modifier
    )
}

@Preview
@Composable
private fun FilterButtonPreview() {
    ComposeRecipeAppTheme {
        FilterButton(
            selected = false,
            label = "Text",
            onClick = {},
        )
    }
}