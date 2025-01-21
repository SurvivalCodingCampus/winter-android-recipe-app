package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TimeFilter(
    selectedIndex: Int,
    onChangeSelected: (Int) -> Unit,
) {
    val list = listOf("All", "Newest", "Oldest", "Popularity")

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        list.forEachIndexed { index, label ->
            FilterButton(
                label = label,
                selected = index == selectedIndex,
                onClick = {
                    onChangeSelected(index)
                },
            )
        }
    }
}

@Preview
@Composable
private fun TimeFilterPreview() {
    ComposeRecipeAppTheme {
        TimeFilter(
            selectedIndex = 0,
            onChangeSelected = {}
        )
    }
}