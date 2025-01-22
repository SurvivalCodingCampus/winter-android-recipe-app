package com.surivalcoding.composerecipeapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToSignIn: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.splash_bg),
                contentScale = ContentScale.Crop
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        AppColors.black
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(104.dp))

            Image(
                modifier = Modifier.size(79.dp),
                painter = painterResource(R.drawable.splash_logo),
                contentDescription = "Recipe App Logo"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "100K+ Premium Recipe",
                style = AppTextStyles.mediumTextBold.copy(
                    color = AppColors.white
                )
            )

            Spacer(modifier = Modifier.height(222.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Get\nCooking",
                style = AppTextStyles.titleTextBold.copy(
                    color = AppColors.white,
                    lineHeight = 60.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Simple way to find Tasty Recipe",
                style = AppTextStyles.normalTextRegular.copy(
                    color = AppColors.white
                )
            )

            Spacer(modifier = Modifier.height(64.dp))

            MediumButton(
                buttonText = "Start Cooking",
                //onClick = onNavigateToSignIn
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}