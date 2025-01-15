package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun BasicTab(
    modifier: Modifier = Modifier,
    labels: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .padding(horizontal = 30.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        labels.forEachIndexed { idx, value ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(
                        color = if (selectedIndex == idx) AppColors.primary_100 else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable { onValueChange(idx) }
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = value,
                    textAlign = TextAlign.Center,
                    style = if (selectedIndex == idx) AppTextStyles.smallTextBold.copy(color = AppColors.white)
                    else AppTextStyles.smallTextBold.copy(color = AppColors.primary_80)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun BasicTabPreviewIndexZero() {
    BasicTab(
        labels = listOf("Label", "Label"),
        selectedIndex = 0
    ) {
        println("인덱스 출력 $it")
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicTabPreviewIndexFirst() {
    BasicTab(
        labels = listOf("Label", "Label"),
        selectedIndex = 1
    )
}