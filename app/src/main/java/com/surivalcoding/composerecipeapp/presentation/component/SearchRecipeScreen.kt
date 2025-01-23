package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.isEmpty
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchRecipeScreen(
    modifier: Modifier = Modifier,
    typing: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit,
    state: State<SavedRecipesState>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.white)
            .padding(
                top = 54.dp,
                start = 30.dp,
                end = 30.dp
            ),
    ) {
        Row(
            modifier = Modifier
                .height(27.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(69.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(R.drawable.arrowleft),
                contentDescription = null
            )

            Text(
                text = "Search recipes",
                style = AppTextStyles.mediumTextBold,
                color = AppColors.Label_Colour
            )
        }

        Spacer(
            modifier = Modifier
                .padding(17.dp)
        )

        Row(
            modifier = Modifier
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .width(255.dp)
                    .height(40.dp)
                    .border(
                        width = 1.3.dp,
                        color = AppColors.gray_04,
                        shape = RoundedCornerShape(10.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    painter = painterResource(R.drawable.searchnormal),
                    contentDescription = null
                )
                Spacer(
                    modifier = Modifier
                        .padding(10.dp)
                )
                CustomTextField(
                    value = typing,
                    onValueChange = onValueChanged,
                    label = "Search recipe",
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(15.dp)
            )
            Image(
                modifier = Modifier
                    .size(40.dp),
                painter = painterResource(R.drawable.filter),
                contentDescription = null
            )
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                text = if(state.value.isSearching) {
                    "Search Result"
                } else {
                    "Recent Search"
                },
                style = AppTextStyles.normalTextBold,
                color = AppColors.black
            )
            // 이후 검색 결과 건수를 표시해주어야 함
            Text(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                text = "${state.value.dataCount} result",
                style = AppTextStyles.smallerTextRegular,
                color = AppColors.gray_03
            )
        }

        Spacer(
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        LazyVerticalGrid(
            modifier =  Modifier,
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            content = {
                if(state.value.isLoading) {
                    items(state.value.dataCount) {
                        RecipeCardLoadingUIForSearch()
                    }
                } else {
                    items(state.value.dataCount) { index ->
                        RecipeCardForSearch(
                            foodImage = state.value.foodImages[index],
                            title = state.value.titles[index],
                            chefName = state.value.chefNames[index],
                            rate = state.value.rates[index],
                        )
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchRecipeScreenPreview() {
    var typing by remember { mutableStateOf(TextFieldValue("")) }
//    SearchRecipeScreen(
//        typing = typing,
//        onValueChanged = {
//            newText ->
//            typing = newText
//        }
//    )
}

@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = AppTextStyles.smallerTextRegular, // 글씨 크기 설정
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .padding(0.dp) // 내부 패딩 추가
                    .fillMaxWidth() // 가로로 꽉 채우기
                    .fillMaxHeight() // 높이 설정
                    .background(AppColors.white) // 배경색 설정,
                ,
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.text.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterStart),
                        text = label,
                        color = AppColors.gray_04
                    )
                }
                innerTextField()
            }
        }
    )
}