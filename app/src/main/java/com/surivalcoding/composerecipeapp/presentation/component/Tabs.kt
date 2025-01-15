package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    labels: List<String>,
    selectedIndex: Int = 0,
    onValueChange: (Int) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()  // 고정 width 대신 fillMaxWidth 사용
            .wrapContentHeight()  // 고정 height 제거
            .background(color = AppColors.white)
            .padding(horizontal = 30.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        labels.forEachIndexed { index, label ->
            Tab(
                label = label,
                selected = index == selectedIndex,
                onClick = { onValueChange(index) },
                modifier = Modifier.weight(1f)  // 각 탭이 동일한 비율로 공간 차지
            )
        }
    }
}

@Composable
private fun Tab(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .heightIn(min = 33.dp)  // 최소 높이만 지정
            .background(
                color = if (selected) AppColors.primary100 else AppColors.white,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 8.dp),  // 상하 패딩 조정
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = AppTextStyles.smallerTextBold.copy(
                color = if (selected) AppColors.white else AppColors.primary80,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(vertical = 4.dp)  // 텍스트 상하 여백 추가
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TabsPreview() {
    Tabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 0,
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TabsSecondSelectedPreview() {
    Tabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 1,
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TabsThreeItemsPreview() {
    Tabs(
        labels = listOf("Label", "Label", "Label"),
        selectedIndex = 1,
        onValueChange = {}
    )
}