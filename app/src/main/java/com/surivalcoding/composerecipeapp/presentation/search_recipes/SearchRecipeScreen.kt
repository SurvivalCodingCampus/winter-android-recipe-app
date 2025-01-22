package com.surivalcoding.composerecipeapp.presentation.search_recipes

import AppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.SearchRecipeCard
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchRecipeScreen(
    state: SearchRecipeState = SearchRecipeState(),
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = Color.White),
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            "Search recipes",
            style = AppTextStyles.normalTextBold.copy(
                fontSize = 18.sp,
                color = AppColors.font
            )
        )
        Spacer(modifier.height(17.dp))
        Row(
            modifier
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically

        ) {

            OutlinedTextField(
                value = state.searchText,
                onValueChange = { text ->
                    onValueChange(text)
                },
                modifier = Modifier
                    .weight(9f)
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = "Search recipe",
                        style = TextStyle(fontSize = 11.sp, color = AppColors.gray4)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = AppColors.gray4
                    )
                },
                shape = RoundedCornerShape(10.dp), // 필드의 둥근 모서리 설정
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AppColors.primary80,  // 선택된 상태의 테두리 색
                    unfocusedBorderColor = AppColors.gray4 // 비선택 상태의 테두리 색
                ),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black)
            )
            Spacer(modifier.width(20.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Unspecified // 아이콘 원래 색상 유지
            )


        }
        Spacer(modifier.height(20.dp))

        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                state.searchTitle,
                style = AppTextStyles.normalTextBold
            )
            Text(
                if (state.recipes.isEmpty()) {
                    ""
                } else {
                    "${state.recipes.size} results"
                },
                style = AppTextStyles.normalTextRegular.copy(
                    fontSize = 11.sp,
                    color = AppColors.gray3
                )
            )
        }
        Spacer(modifier.height(20.dp))
        LazyVerticalGrid(
            modifier = modifier.fillMaxWidth(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            items(state.recipes.size) { item ->
                Box(
                    modifier
                        .width(150.dp)
                        .height(150.dp)
                ) {
                    SearchRecipeCard(
                        recipe = state.recipes[item]
                    )
                }
            }
        }
    }

}

@Composable
fun BodyContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = Color.Black),
    ) {
        Row(
            modifier
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically

        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(9f),
                placeholder = {
                    Text(
                        text = "Search recipe",
                        style = TextStyle(fontSize = 11.sp, color = AppColors.gray4)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = AppColors.gray4
                    )
                },
                shape = RoundedCornerShape(10.dp), // 필드의 둥근 모서리 설정
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AppColors.primary80,  // 선택된 상태의 테두리 색
                    unfocusedBorderColor = AppColors.gray4 // 비선택 상태의 테두리 색
                ),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black)
            )
            Spacer(modifier.width(20.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Unspecified // 아이콘 원래 색상 유지
            )


        }
        Spacer(modifier.height(20.dp))

        Row(modifier.fillMaxWidth()) {
            Text("Recent Search222")
        }
    }
}

@Preview
@Composable
private fun SearchRecipeScreenPreview() {
    SearchRecipeScreen()

}