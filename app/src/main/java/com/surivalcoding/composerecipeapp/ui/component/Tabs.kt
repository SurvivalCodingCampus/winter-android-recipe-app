package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.custom.HoTab
import com.surivalcoding.composerecipeapp.ui.custom.HoTabRow
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme


@Composable
fun Tabs(
    labels: List<String>,
    selectedTabIndex: Int,
    onClickTab: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    HoTabRow(
        modifier = modifier,
        containerColor = AppColors.White
    ) {
        labels.forEachIndexed { index, label ->
            HoTab(
                label = label,
                selected = index == selectedTabIndex,
                onClick = {
                    onClickTab(index)
                },
                textStyle = AppTextStyles.smallerTextSemiBold
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
            },
            modifier = Modifier.height(58.dp)
        )
    }
}