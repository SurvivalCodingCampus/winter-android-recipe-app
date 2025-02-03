package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.FilterSearchBottomSheet
import com.surivalcoding.composerecipeapp.presentation.item.RecipeListGrid
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import kotlinx.coroutines.launch


@Composable
fun SearchRecipeScreen(
    state: SearchRecipesState,
    onAction: (SearchRecipeAction) -> Unit,
) {
    // coroutine
    val coroutineScope = rememberCoroutineScope()

    // BottomSheet 상태
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    LaunchedEffect(bottomSheetState.isVisible) {
        // 다이얼로그 닫힘 감지
        if (!bottomSheetState.isVisible) {
            onAction(SearchRecipeAction.HandleBottomSheet(false))
        }
    }

    ModalBottomSheetLayout(
        sheetContent = {
            FilterSearchBottomSheet(
                state = state,
                onAction = onAction,
                bottomSheetState = bottomSheetState,
                coroutineScope = coroutineScope
            )
        },
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        sheetBackgroundColor = AppColors.white
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterStart)
                )

                Text(
                    text = "Search recipes",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.label_color,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(17.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                BasicTextField(
                    value = state.filterText,
                    onValueChange = { newText ->
                        onAction(SearchRecipeAction.FilterSearchChange(newText))
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    textStyle = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.black
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = AppColors.white)
                                .border(1.dp, color = AppColors.gray_4, shape = RoundedCornerShape(10.dp))
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                contentDescription = "search",
                                modifier = Modifier.size(18.dp),
                                tint = AppColors.gray_4
                            )

                            Spacer(modifier = Modifier.width(width = 8.dp))

                            // 커서 위치로 인해 Box로 래핑
                            Box {
                                // 기본적으로 placeHolder를 지원하지 않아 직접 구현을 해줘야함
                                if (state.filterText.isBlank()) {
                                    Text(
                                        text = "Search recipe",
                                        style = AppTextStyles.smallTextRegular.copy(
                                            fontSize = 11.sp,
                                            color = AppColors.gray_4
                                        )
                                    )
                                }

                                innerTextField()
                            }
                        }
                    }
                )

                // 필터 아이콘
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(AppColors.primary_100, shape = RoundedCornerShape(10.dp))
                        .clickable {
                            coroutineScope.launch {
                                bottomSheetState.show()
                                onAction(SearchRecipeAction.HandleBottomSheet(true))
                            }
                        }
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(R.drawable.setting_4),
                        contentDescription = null
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (state.filterText.isBlank()) "Recent Search" else "Search Result",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        fontSize = 16.sp,
                        color = AppColors.black
                    )
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = "${state.filteredRecipeList.size} results",
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            RecipeListGrid(
                state = state,
                onAction = onAction
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.loadingState.isLoading) {
            // 로딩 바 적용
            CircularProgressIndicator(
                color = AppColors.primary_100
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SearchRecipeScreenPreview() {
    SearchRecipeScreen(
        state = SearchRecipesState(),
        onAction = {}
    )
}