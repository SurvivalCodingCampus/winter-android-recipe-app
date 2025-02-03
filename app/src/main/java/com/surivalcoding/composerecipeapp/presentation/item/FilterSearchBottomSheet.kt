package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.item.button.ButtonState
import com.surivalcoding.composerecipeapp.presentation.item.button.FilterButton
import com.surivalcoding.composerecipeapp.presentation.item.button.RatingButton
import com.surivalcoding.composerecipeapp.presentation.item.button.SmallButton
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeAction
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipesState
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Time
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterSearchBottomSheet(
    state: SearchRecipesState,
    onAction: (SearchRecipeAction) -> Unit,
    bottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope // 전달받은 coroutineScope
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(31.dp))

        Text(
            text = "Filter Search",
            style = AppTextStyles.mediumTextSemiBold.copy(
                AppColors.black,
                fontSize = 14.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {

            Text(
                text = "Time",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    AppColors.black,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (time in Time.entries) {
                    FilterButton(
                        text = time.displayName,
                        isSelected = time.name == state.filterState.selectedTime, // 선택된 시간 상태 확인
                        onClick = {
                            val newFilterState = state.filterState.copy(
                                selectedTime = if (time.name == state.filterState.selectedTime) Time.All.name else time.name
                            )
                            onAction(SearchRecipeAction.UpdateFilter(newFilterState))
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Rate",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    AppColors.black,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (i in 5 downTo 1) {
                    RatingButton(
                        text = i.toString(),
                        isSelected = i == state.filterState.selectedRate, // 선택된 별점 상태 확인
                        onClick = {
                            val newFilterState = state.filterState.copy(
                                selectedRate = if (i == state.filterState.selectedRate) 0 else i
                            )
                            onAction(SearchRecipeAction.UpdateFilter(newFilterState))
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Category",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    AppColors.black,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            FlowRow(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (category in Category.entries) {
                    FilterButton(
                        text = category.displayName,
                        isSelected = category.name == state.filterState.selectedCategory, // 선택된 카테고리 상태 확인
                        onClick = {
                            val newFilterState = state.filterState.copy(
                                selectedCategory = if (category.name == state.filterState.selectedCategory) Category.All.name else category.name
                            )
                            onAction(SearchRecipeAction.UpdateFilter(newFilterState))
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        SmallButton(
            text = "Filter",
            buttonState = ButtonState.NORMAL,
            onClick = {
                onAction(SearchRecipeAction.ApplyFilter)

                coroutineScope.launch {
                    bottomSheetState.hide()
                }
                onAction(SearchRecipeAction.HandleBottomSheet(false))
            }
        )

        Spacer(modifier = Modifier.height(22.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterSearchBottomSheetPreview() {

    // BottomSheet 상태
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    FilterSearchBottomSheet(
        state = SearchRecipesState(),
        onAction = {},
        bottomSheetState = bottomSheetState,
        coroutineScope = coroutineScope,
    )
}

