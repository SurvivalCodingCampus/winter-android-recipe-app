package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarBorder
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
fun RatingDialog(
    title: String,
    modifier: Modifier = Modifier,
    starFill: MutableList<Color>,
    select: Int,
    onClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .width(170.dp)
            .height(91.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            Text(
                modifier = Modifier
                    .width(63.dp)
                    .height(17.dp),
                text = title,
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(
            modifier = Modifier
                .padding(vertical = 2.5.dp)
        )
        Row(
            modifier = Modifier
                .width(140.dp)
                .height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = null,
                    tint = starFill[0],
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = null,
                    tint = starFill[1],
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = null,
                    tint = starFill[2],
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = null,
                    tint = starFill[3],
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = null,
                    tint = starFill[4],
                )
            }
        }
        Spacer(
            modifier = Modifier
                .padding(vertical = 2.5.dp)
        )
        Box {
            Box(
                modifier = Modifier
                    .width(61.dp)
                    .height(20.dp)
                    .background(color = AppColors.gray_04, shape = RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier
                        .width(21.dp)
                        .padding(vertical = 2.dp),
                    text = "send",
                    color = Color.White,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun RatingDialogPreview() {
    var starFill by remember { mutableStateOf(mutableListOf<Color>()) }
    var select by remember { mutableStateOf(-1) }

    for (i in 1 .. 5) {
        starFill.add(AppColors.yellow)
    }
    RatingDialog(
        title = "Rate recipe",
        starFill = starFill,
        select = select,
        onClick = {

        }
    )
}