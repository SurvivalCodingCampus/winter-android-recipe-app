package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.component.CraTab
import com.surivalcoding.composerecipeapp.ui.component.CraTabRow
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme


@Composable
fun Tabs(
    labels: List<String>,
    selectedTabIndex: Int,
    onClickTab: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    CraTabRow(
        modifier = modifier
            .height(58.dp)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        containerColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        labels.forEachIndexed { index, label ->
            CraTab(
                label = label,
                selected = index == selectedTabIndex,
                onClick = {
                    onClickTab(index)
                },
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Preview
@Composable
fun TabsPreview() {
    ComposeRecipeAppTheme {
        val labels = listOf("Topics", "People", "banana")
        Tabs(
            selectedTabIndex = 0,
            labels = labels,
            onClickTab = {
            }
        )
    }
}