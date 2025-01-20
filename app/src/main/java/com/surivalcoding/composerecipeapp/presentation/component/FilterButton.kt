package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

/*@Composable
fun FilterButton(
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
            .clickable(onClick = onClick1),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier,
                text = "hello",
                fontSize = 11.sp,
                color = textColorFirst,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(horizontal = 2.5.dp))
        }
        Spacer(Modifier.padding(8.dp))
        Row(modifier = Modifier
            .background(color = backGroundColorSecond, shape = RoundedCornerShape(8.dp))
            .border(1.dp, color = AppColors.primary, shape = RoundedCornerShape(8.dp))
            .width(50.dp)
            .height(28.dp)
            .clickable(onClick = onClick2),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier,
                text = "hello",
                fontSize = 11.sp,
                color = textColorSecond,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(horizontal = 2.5.dp))
        }
    }
}*/

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean
    ) {
    Box(
        modifier = Modifier
            .width(43.dp)
            .height(27.dp)
            .border(
                width = 1.dp,
                brush = if(isSelected) {
                    SolidColor(AppColors.white)
                } else {
                    SolidColor(AppColors.primary_80)
                },
                shape = RoundedCornerShape(10.dp))
            .background(
                color = if(isSelected) {
                    AppColors.primary_100
                } else {
                    AppColors.white
                },
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .width(23.dp)
                .height(17.dp),
            text = text,
            textAlign = TextAlign.Center,
            style = AppTextStyles.smallerTextRegular,
            color = if(isSelected) {
                AppColors.white
            } else {
                AppColors.primary_80
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun FilterButtonPreview() {
    /*var backGroundColorFirst by remember { mutableStateOf(AppColors.primary) }
    var textColorFirst by remember { mutableStateOf(Color.White) }
    var backGroundColorSecond by remember { mutableStateOf(Color.White) }
    var textColorSecond by remember { mutableStateOf(AppColors.primary) }
    FilterButton(
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
        })*/

    FilterButton(
        text = "text",
        isSelected = true
    )
}