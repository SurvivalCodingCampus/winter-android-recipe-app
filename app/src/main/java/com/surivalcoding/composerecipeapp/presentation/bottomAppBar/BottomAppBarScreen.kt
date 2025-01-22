package com.surivalcoding.composerecipeapp.presentation.bottomAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.navigation.Route
import com.surivalcoding.composerecipeapp.presentation.home.HomeState
import com.surivalcoding.composerecipeapp.ui.AppColors


@Composable
fun BottomAppBarScreen(
    state: HomeState = HomeState(
        keyword = "",
        isSelected = Route.Splash,
        isLoading = true,
        isSearching = false,
    ),
    onClickAddRecipe: () -> Unit = {},
    onClickToHome: () -> Unit = {},
    onClickToSavedRecipes: () -> Unit = {},
    onClickToNotification: () -> Unit = {},
    onClickToProfile: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .height(110.dp)
            .background(color = Color.Transparent),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.height(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.Transparent)
            ) {
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .paint(
                    painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.FillBounds
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                // 왼쪽 아이콘들
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Box(modifier = Modifier.clickable {
                        onClickToHome()
                    }) {

                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "home",
                            modifier = Modifier.size(24.dp),
                            tint = if (state.isSelected == Route.Home) AppColors.Primary100 else AppColors.BottomIcon,
                        )
                    }
                    Box(modifier = Modifier.clickable {
                        onClickToSavedRecipes()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Book,
                            contentDescription = "book",
                            modifier = Modifier.size(24.dp),
                            tint = if (state.isSelected == Route.RecentlySearchRecipe) AppColors.Primary100 else AppColors.BottomIcon
                        )
                    }
                }

                // 가운데 + 버튼
                if (state.isSelected == Route.RecentlySearchRecipe) {
                    Box(
                        modifier = Modifier
                            .offset(y = (-35).dp)  // 위로 올리기
                            .size(48.dp)
                            .background(
                                color = AppColors.Primary100, shape = CircleShape
                            )
                            .clickable {
                                onClickAddRecipe()
                            }, contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "plus",
                            modifier = Modifier.size(21.dp),
                            tint = AppColors.White
                        )
                    }
                }

                // 오른쪽 아이콘들
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Box(modifier = Modifier.clickable {
                        onClickToNotification()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "alarm",
                            modifier = Modifier.size(24.dp),
                            tint = if (state.isSelected == Route.Notification) AppColors.Primary100 else AppColors.BottomIcon
                        )
                    }
                    Box(modifier = Modifier.clickable {
                        onClickToProfile()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "person",
                            modifier = Modifier.size(24.dp),
                            tint = if (state.isSelected == Route.Profile) AppColors.Primary100 else AppColors.BottomIcon
                        )

                    }
                }
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun BottomAppBarScreenPreview() {
    BottomAppBarScreen()
}


