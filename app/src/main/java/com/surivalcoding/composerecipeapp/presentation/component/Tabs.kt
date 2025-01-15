package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    labels: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit,
) {
    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 30.dp),
        indicator = {},
        divider = {},
    ) {
        labels.forEachIndexed { index, label ->
            val isSelected = selectedIndex == index
            Tab(
                modifier = Modifier
                    .width(150.dp)
                    .height(33.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (isSelected) AppColors.primary else AppColors.white
                    ),
                selected = isSelected,
                onClick = { onValueChange(index) },
                text = {
                    Text(
                        style = AppTextStyles.normalTextBold.copy(
                            fontSize = 11.sp
                        ),
                        text = label,
                        color = if (isSelected) AppColors.white else AppColors.primary80
                    )
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    Tabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 0,
        onValueChange = { index -> println("Selected Tab: $index") }
    )
}

@Preview(showBackground = true)
@Composable
fun TabsPreview2() {
    Tabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 1,
        onValueChange = { index -> println("Selected Tab: $index") }
    )
}
