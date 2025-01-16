package com.surivalcoding.composerecipeapp.presentation.component

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .fillMaxWidth(1f)) {    // Spacer로 패딩 잡아줬으니 height값은 잡아줄 필요가 없다.
        Spacer(modifier = Modifier
            .weight(0.03f))
        Column() {
            Spacer(modifier = Modifier
                .padding(top = 86.dp))
            Box() {
                // 요리명
                Text(text = "Traditional spare ribs baked")
            }
            Box() {
                // 요리사
                Text(text = "By Chef John")
            }
            Spacer(modifier = Modifier
                .padding(bottom = 10.dp))
        }
        Spacer(modifier = Modifier
              .weight(0.09f))
        Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.SpaceBetween) {
            Spacer(modifier = Modifier
                .padding(top = 10.dp))
            Row() {
                Box() {
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
            Spacer(modifier = Modifier
                .padding(vertical = 30.dp))
            Row() {
                Row() {
                    Box() {
                        // 시계 아이콘
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Sharp.Star,
                            contentDescription = null,
                            tint = Color.Yellow,
                        )
                    }
                    Box() {
                        // 시간
                        Text(text = "20 min")
                    }
                }
                Box() {
                    // 북마크
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Sharp.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                    )
                }

            }
        }
        Spacer(modifier = Modifier
            .weight(0.03f))
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard()
}