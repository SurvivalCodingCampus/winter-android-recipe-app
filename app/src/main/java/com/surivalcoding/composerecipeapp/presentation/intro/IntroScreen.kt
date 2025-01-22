package com.surivalcoding.composerecipeapp.presentation.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun IntroScreen(
    onClickStart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red),
    ) {
        Image(
            painter = painterResource(id = R.drawable.intro_background),
            contentDescription = "intro image",
            contentScale = ContentScale.FillBounds,
            modifier = modifier.matchParentSize(),
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Black,
                        )
                    )
                )
        )
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            Column(
                modifier = modifier.matchParentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(104.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_intro),
                    contentDescription = "chef hat",
                    modifier = Modifier.size(80.dp),
                )
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "100K+ Premium Recipe",
                    style = AppTextStyles.mediumTextSemiBold,
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Get\nCooking",
                    textAlign = TextAlign.Center,
                    style = AppTextStyles.titleTextSemiBold,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Simple way to find Tasty Recipe",
                    style = AppTextStyles.normalTextRegular,
                )
                Spacer(Modifier.height(64.dp))
                MediumButton(
                    text = "Start Cooking",
                    onClick = onClickStart,
                )
                Spacer(Modifier.height(62.dp))
            }
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    ComposeRecipeAppTheme {
        IntroScreen(onClickStart = {})
    }
}