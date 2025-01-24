package com.surivalcoding.composerecipeapp.presentation.component.splash

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val splashScreenBackgroundImageUrl =
        "https://s3-alpha-sig.figma.com/img/abb8/bc9a/d3d82b4122f5602afeadd620a4c53d15?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YwzE-yb5SnMQPTrMInLmrj461FsTOpR3Ho6oEweE6EFC-Plhi4f6JkluuB~5gCswPcJeUsHvXhJF32x08IM97HgZ4d1FuBMP85unrnWp9hW5Y01wkySPNED-NLBVasfH1iAx2FQ6Cp84gkF6YUdmwzuwjnlNK6RjHVFPFOUwJhl7fJCMLshgc2mNHSDt1-QlzHySQt0J1AbZX6JD9e7J0ctdpSej6ulR2tSCvXKMG05J3qCnhINshU1xMUnSrTWO0HeKnSNSJ9FXVZ1M1qh6B7f7ZBfzEHG~0y-0c48fONBFG~MZuEhVvVBc4rOp9tXuywwBlL1YCtWkXMfLz8CiMw__"
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = if (LocalInspectionMode.current) {
                ColorDrawable(Color.Green.toArgb())
            } else {
                splashScreenBackgroundImageUrl
            },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black), // 투명 -> 검정
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 94.dp, bottom = 34.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(79.dp),
                    painter = painterResource(R.drawable.toque),
                    contentDescription = null
                )
                Text(
                    text = "100K+ Premium Recipe",
                    style = AppTextStyles.mediumTextBold,
                    color = AppColors.white
                )

                Spacer(
                    modifier = Modifier
                        .padding(vertical = 100.dp)
                )
                Text(
                    text = "Get\nCooking",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 60.sp,
                    textAlign = TextAlign.Center,
                    color = AppColors.white
                )


                Text(
                    text = "Simple way to find Tasty Recipe",
                    style = AppTextStyles.normalTextRegular,
                    color = AppColors.white
                )

                Spacer(
                    modifier = Modifier
                        .padding(vertical = 32.dp)
                )
                MediumButton(
                    title = "Start Cooking",
                    onClick = {
                        onClick()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}