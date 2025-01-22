package com.surivalcoding.composerecipeapp.presentation.home

import IngredientDto
import Recipe
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(
    state: HomeState,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    onSearching: (Boolean) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier
            .padding(start = 20.dp, bottom = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Hello Jega", style = AppTextStyles.boldMedium)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFD9D9D9),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onSearching(true)
                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search Icon",
                        tint = AppColors.LabelWhite,
                        modifier = Modifier.size(18.dp)
                    )
                    if (state.isSearching) {
                        BasicTextField(
                            value = state.keyword,
                            onValueChange = {
                                onValueChange(it)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester),
                            textStyle = AppTextStyles.regularSmaller,
                            singleLine = true,
                            cursorBrush = SolidColor(AppColors.Primary100)
                        )
                    } else {
                        Text(
                            text = "Search recipe",
                            style = AppTextStyles.regularSmaller,
                            color = AppColors.LabelWhite
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = AppColors.Primary100,
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Settings Icon",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }

    // 포커스 요청
    LaunchedEffect(state.isSearching) {
        if (state.isSearching) {
            delay(100)
            focusRequester.requestFocus()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    val recipe = Recipe(
        id = 30,
        name = "hh",
        time = "10",
        category = "Itailian",
        image = "http://",
        chef = "steve",
        rating = 3.0,
        ingredients = listOf<IngredientDto>(IngredientDto(1, "a", "b")),
    )

    val recipes = listOf(
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe
    )

//    HomeScreen(
//        HomeState(recipeList = recipes),
//        onValueChange = {},
//        onSearching = {},
//        modifier = Modifier,
//    )

}
