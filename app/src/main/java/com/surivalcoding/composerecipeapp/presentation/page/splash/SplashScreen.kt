package com.surivalcoding.composerecipeapp.presentation.page.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.button.ButtonState
import com.surivalcoding.composerecipeapp.presentation.item.button.MediumButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.splash_background),
                contentScale = ContentScale.Crop
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent, Color.Black
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Image(
                modifier = Modifier
                    .size(79.dp),
                painter = painterResource(R.drawable.splash_logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "100K+ Premium Recipe",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    color = AppColors.white
                )
            )

            Spacer(modifier = Modifier.height(222.dp))

            Text(
                modifier = Modifier.width(213.dp),
                text = "Get Cooking",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    fontSize = 50.sp, color = AppColors.white
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Simple way to find Tasty Recipe",
                style = AppTextStyles.smallTextRegular.copy(
                    fontSize = 16.sp,
                    color = AppColors.white
                )
            )

            Spacer(modifier = Modifier.height(64.dp))

            MediumButton(text = "Start Cooking", buttonState = ButtonState.NORMAL) {
                onClick()
            }
        }
    }
}


@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen {
        // 화면 이동 처리 필요
    }
}