package com.surivalcoding.composerecipeapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.global.button.BaseButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SplashScreen(
    state: SplashState,
    onStartClick: (Boolean) -> Unit,
) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.splash),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_main),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(79.dp)
                )
                Text("100K+ Premium Recipe", style = AppTextStyles.boldLarge, color = Color.White)
                Spacer(modifier = Modifier.padding(100.dp))


                Text(
                    "Get\nCooking",
                    style = AppTextStyles.boldTitle,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    "Simple way find Tasty Recipe",
                    style = AppTextStyles.regularNormal,
                    color = Color.White
                )
                Spacer(
                    modifier = Modifier.padding(15.dp)
                )

                BaseButton(
                    modifier = Modifier,
                    width = 250.dp,
                    height = 50.dp,
                    text = "Start Cooking",
                    color = AppColors.Primary100,
                    fontStyle = AppTextStyles.regularNormal,
                    iconSize = 15.dp,
                    enabled = true,
                    onClick = {
                        onStartClick(state.onClick)
                    }
                )
            }

        }


    }



@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SplashScreen(
        SplashState(),
        onStartClick = {},
    )
}