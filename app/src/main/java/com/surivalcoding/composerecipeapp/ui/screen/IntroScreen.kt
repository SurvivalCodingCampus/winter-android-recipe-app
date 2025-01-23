package com.surivalcoding.composerecipeapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography

@Composable
fun IntroScreen(enableEdgeToEdge: Unit) {
    Box(
        modifier = Modifier
            .paint(
                painter = painterResource(R.drawable.img_intro_background),
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 60.dp, bottom = 14.dp),
                    painter = painterResource(R.drawable.img_chef_hat),
                    contentDescription = "Chef Hat"
                )
                Text(
                    text = "100K+ Premium Recipe",
                    style = PoppinsBoldTypography.headlineMedium.copy(
                        color = Color.White
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Get\nCooking",
                    style = PoppinsBoldTypography.headlineLarge.copy(
                        fontSize = 50.sp,
                        lineHeight = 60.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )

                Text(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    text = "Simple way to find Tasty Recipe",
                    style = PoppinsRegularTypography.bodyLarge.copy(
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )

                MediumButton(
                    modifier = Modifier
                        .padding(top = 64.dp, bottom = 50.dp),
                    text = "Start Cooking"
                )
            }
        }
    }
}