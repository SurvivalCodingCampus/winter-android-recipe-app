package com.surivalcoding.composerecipeapp.presentation.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.BottomNavigationUI
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.white)
            .padding(top = 64.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
            ) {
                Column {
                    Text(
                        text = "Hello Jega",
                        style = AppTextStyles.largeTextBold,
                        color = AppColors.black
                    )
                    Spacer(modifier = Modifier.padding(vertical = 2.5.dp))
                    Text(
                        text = "what are you cooking today?",
                        style = AppTextStyles.smallerTextRegular,
                        color = AppColors.gray_03
                    )
                }
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    painter = painterResource(R.drawable.avatar_sample),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clickable {
                            onClick()
                        },
                    painter = painterResource(R.drawable.search_image),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    painter = painterResource(R.drawable.filter),
                    contentDescription = null
                )
            }
        }

        BottomNavigationUI(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}