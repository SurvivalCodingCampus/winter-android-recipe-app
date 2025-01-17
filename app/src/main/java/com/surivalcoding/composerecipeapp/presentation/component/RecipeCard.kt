package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.rounded.Alarm
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun RecipeCard(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(color = Color.Red, shape = RoundedCornerShape(20.dp))
    ) {    // Spacer로 패딩 잡아줬으니 height값은 잡아줄 필요가 없다.
        Spacer(
            modifier = Modifier
                .weight(0.03f)
        )
        Column() {
            Spacer(
                modifier = Modifier
                    .padding(top = 86.dp)
            )
            Column(modifier = Modifier) {
                Text(text = "Traditional spare ribs baked", softWrap = true, fontSize = 14.sp, color = Color.White)
                Text(
                    modifier = Modifier
                        .width(53.dp)
                        .height(12.dp),
                    text = "By Chef John",
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center,
                    color = AppColors.gray)
            }

            Spacer(
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.09f)
        )
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Row(
                modifier = Modifier
                    .width(37.dp)
                    .height(16.dp)
                    .background(shape = RoundedCornerShape(10.dp), color = AppColors.lightyello)
            ) {
                Box(modifier = Modifier) {
                    // 별
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Sharp.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                    )
                }
                Box() {
                    // 평점
                    Text("4.0")
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 30.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row() {
                    Box(
                        modifier = Modifier
                            .width(17.dp)
                            .height(17.dp)
                    ) {
                        // 시계 아이콘
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Outlined.Alarm,
                            contentDescription = null,
                            tint = AppColors.gray,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 2.5.dp)
                    )
                    Box(
                        modifier = Modifier
                            .width(38.dp)
                            .height(17.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // 시간
                        Text(
                            text = "20 min",
                            color = AppColors.gray,
                            fontSize = 11.sp
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                )
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(color = Color.White)
                        .width(24.dp)
                        .height(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                        contentAlignment = Alignment.Center) {
                        // 북마크
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Rounded.BookmarkBorder,
                            contentDescription = null,
                            tint = AppColors.primary,
                        )
                    }

                }

            }
        }
        Spacer(
            modifier = Modifier
                .weight(0.03f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard()
}