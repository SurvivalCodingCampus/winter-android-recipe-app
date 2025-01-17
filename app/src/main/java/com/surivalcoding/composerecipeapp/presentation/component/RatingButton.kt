package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun RatingButton(
    modifier: Modifier = Modifier,
    backGroundColorFirst: Color,
    backGroundColorSecond: Color,
    textColorFirst: Color,
    textColorSecond: Color,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier
            .background(color = backGroundColorFirst, shape = RoundedCornerShape(8.dp))
            .border(1.dp, color = AppColors.primary, shape = RoundedCornerShape(8.dp))
            .width(50.dp)
            .height(28.dp)
            .padding(horizontal = 10.dp)
            .clickable(onClick = onClick1),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier,
                text = "5",
                fontSize = 11.sp,
                color = textColorFirst,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(horizontal = 2.5.dp))
            Icon(
                modifier = Modifier
                    .width(18.dp),
                imageVector = Icons.Sharp.Star,
                contentDescription = null,
                tint = textColorFirst,
            )
        }

        Spacer(Modifier.padding(17.dp))

        Row(modifier = Modifier
            .background(color = backGroundColorSecond, shape = RoundedCornerShape(8.dp))
            .border(1.dp, color = AppColors.primary, shape = RoundedCornerShape(8.dp))
            .width(50.dp)
            .height(28.dp)
            .padding(horizontal = 10.dp)
            .clickable(onClick = onClick2),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier,
                text = "5",
                fontSize = 11.sp,
                color = textColorSecond,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(horizontal = 2.5.dp))
            Icon(
                modifier = Modifier
                    .width(18.dp),
                imageVector = Icons.Sharp.Star,
                contentDescription = null,
                tint = textColorSecond,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingButtonPreview() {
    var backGroundColorFirst by remember { mutableStateOf(AppColors.primary) }
    var textColorFirst by remember { mutableStateOf(Color.White) }
    var backGroundColorSecond by remember { mutableStateOf(Color.White) }
    var textColorSecond by remember { mutableStateOf(AppColors.primary) }
    RatingButton(
        backGroundColorFirst = backGroundColorFirst,
        backGroundColorSecond = backGroundColorSecond,
        textColorFirst = textColorFirst,
        textColorSecond = textColorSecond,
        onClick1 = {
            backGroundColorFirst = AppColors.primary
            textColorFirst = Color.White
            backGroundColorSecond = Color.White
            textColorSecond = AppColors.primary
        },
        onClick2 = {
            backGroundColorFirst = Color.White
            textColorFirst = AppColors.primary
            backGroundColorSecond = AppColors.primary
            textColorSecond = Color.White
        })
}