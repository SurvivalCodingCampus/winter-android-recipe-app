package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun BottomNavigationUI(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .height(150.dp)
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.TopCenter)
                .padding(bottom = 10.dp),
            painter = painterResource(R.drawable.menu_icon_bottom_bar),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
                .clip(CurvedBottomBarShape(
                    curveHeight = 200f, cornerRadius = 10f, curveWidth = 0.14f))
                .background(AppColors.white)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomBarItem(
                    icon = R.drawable.home_icon_bottom_bar,
                )
                BottomBarItem(
                    icon = R.drawable.boomark_icon_bottom_bar,
                    color = AppColors.gray_04
                )
                Spacer(modifier = Modifier.width(40.dp)) // 가운데 공간
                BottomBarItem(
                    icon = R.drawable.notificationbell_icon_bottom_bar,
                    color = AppColors.gray_04
                )
                BottomBarItem(
                    icon = R.drawable.profile_icon_bottom_bar,
                    color = AppColors.gray_04
                )
            }
        }
    }

}

@Preview
@Composable
private fun BottomNavigationUIPreview() {
    BottomNavigationUI()
}

@Composable
fun BottomBarItem(icon: Int, color: Color = Color.Transparent) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(color == Color.Transparent) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
            )
        } else {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color)
            )
        }

    }
}

class CurvedBottomBarShape(
    private val curveHeight: Float,
    private val cornerRadius: Float,
    private val curveWidth: Float = 0.3f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                reset()
                val curveStartX = size.width * (0.5f - curveWidth)
                val curveEndX = size.width * (0.5f + curveWidth)

                // 왼쪽 모서리
                moveTo(0f, cornerRadius)
                quadraticBezierTo(0f, 0f, cornerRadius, 0f)

                // 왼쪽에서 곡선 시작점까지
                lineTo(curveStartX - cornerRadius, 0f)

                // 왼쪽 곡선 시작
                quadraticBezierTo(curveStartX, 0f, curveStartX + cornerRadius, cornerRadius)

                // 중앙 곡선
                quadraticBezierTo(size.width * 0.5f, curveHeight, curveEndX - cornerRadius, cornerRadius)

                // 오른쪽 곡선 끝
                quadraticBezierTo(curveEndX, 0f, curveEndX + cornerRadius, 0f)

                // 오른쪽 끝까지
                lineTo(size.width - cornerRadius, 0f)

                // 오른쪽 모서리
                quadraticBezierTo(size.width, 0f, size.width, cornerRadius)

                // 아래쪽과 왼쪽
                lineTo(size.width, size.height)
                lineTo(0f, size.height)

                close()
            }
        )
    }
}