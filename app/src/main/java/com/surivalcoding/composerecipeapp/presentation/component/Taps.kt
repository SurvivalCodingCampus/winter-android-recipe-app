package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    labels: List<String>,
    insideColorFirst: Color,
    insideContentSecond: Color,
    onValueChangeFirst: () -> Unit = {},
    onValueChangeSecond: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .width(375.dp)
            .height(58.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .width(150.dp)
                .height(33.dp)
                .background(color = insideColorFirst, shape = RoundedCornerShape(10.dp))
                .padding(vertical = 8.dp)
                .clickable(onClick = onValueChangeFirst),
            text = labels[0],
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.width(15.dp))
        Text(
            modifier = Modifier
                .width(150.dp)
                .height(33.dp)
                .background(
                    color = insideContentSecond,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(vertical = 8.dp)
                .clickable(onClick = onValueChangeSecond),
            text = labels[1],
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun TapPreview() {
    var insideColorFirst by remember { mutableStateOf(AppColors.primary) }
    var insideColorSecond by remember { mutableStateOf(Color.Transparent) }
    Tabs(
        labels = listOf("first", "second"),
        insideColorFirst = insideColorFirst,
        insideContentSecond = insideColorSecond,
        onValueChangeFirst = {
                insideColorFirst = AppColors.primary
                insideColorSecond = Color.Transparent
        },
        onValueChangeSecond = {
                insideColorFirst = Color.Transparent
                insideColorSecond = AppColors.primary
        }
    )
}