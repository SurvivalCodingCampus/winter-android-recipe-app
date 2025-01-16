package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun FilterChip(
    text: String,
    showStar: Boolean = false,
    isSelected: Boolean,
    onSelectionChange: (Boolean) -> Unit
) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale

    // 기본 아이콘값에 fontScale 적용
    val baseIconSize = 18.dp
    val calculatedIconSize = baseIconSize * fontScale

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = if (isSelected) AppColors.primary100 else AppColors.white
            )
            .defaultMinSize(minHeight = 27.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) AppColors.white else AppColors.primary80,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp)
            .clickable {
                onSelectionChange(!isSelected)  // 클릭 시 현재 상태의 반대값을 전달
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.dp),
            maxLines = 1,
            text = text,
            style = AppTextStyles.smallerTextRegular.copy(
                color = if (isSelected) AppColors.white else AppColors.primary80
            )
        )
        if (showStar) {
            Icon(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(calculatedIconSize),
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (isSelected) AppColors.white else AppColors.primary80
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun FilterChipsPreview() {
    var selected1 by remember { mutableStateOf(false) }
    var selected2 by remember { mutableStateOf(false) }
    var selected3 by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            text = "Newest",
            isSelected = selected1,
            onSelectionChange = { selected1 = it }
        )
        FilterChip(
            text = "4",
            showStar = true,
            isSelected = selected2,
            onSelectionChange = { selected2 = it }
        )
        FilterChip(
            text = "Dinner",
            showStar = true,
            isSelected = selected3,
            onSelectionChange = { selected3 = it }
        )
    }
}