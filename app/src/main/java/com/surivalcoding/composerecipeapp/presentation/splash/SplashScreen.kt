package com.surivalcoding.composerecipeapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SplashScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Column(
            modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_splash_logo),
                    contentDescription = null,
                    modifier = modifier.size(79.dp)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    "100K+ Premium Recipe",
                    style = AppTextStyles.normalTextBold.copy(
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }

            Column(
                modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Get\n" +
                            "Cooking",
                    style = AppTextStyles.normalTextBold.copy(
                        fontSize = 50.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier.height(20.dp))
                Text(
                    "Simple way to find Tasty Recipe",
                    style = AppTextStyles.normalTextRegular.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier.height(64.dp))
                MediumButton(
                    text = "Start Cooking",
                    onClick = onNextButtonClicked
                )
            }
        }


    }

}

@Preview
@Composable
private fun SplashScreenPreview() {
    //SplashScreen()

}