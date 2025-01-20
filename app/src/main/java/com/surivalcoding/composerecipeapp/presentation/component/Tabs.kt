package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    labels: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(58.dp)
            .padding(horizontal = 30.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        labels.forEachIndexed { index, value ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(33.dp)
                    .background(
                        color = if (selectedIndex == index) AppColors.primary else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .semantics {
                        this.testTag = "testTag $index"
                    }
                    .clickable {
                        onValueChange(index)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value,
                    style = AppTextStyles.smallTextBold.copy(
                        color = if (selectedIndex == index) AppColors.white else AppColors.primary_80
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TapPreview() {
    Tabs(
        labels = listOf("first", "second"),
        selectedIndex = 0,
    )
}