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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Time
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterSearchBottomSheet() {
    // 필터 버튼 설정
    val (timeState, onTimeSelected) = remember { mutableStateOf(Time.All.name) }

    val (rateState, onRateSelected) = remember { mutableIntStateOf(5) }

    val (categoryState, onCategorySelected) = remember { mutableStateOf(Category.All.name) }


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
                        isSelected = time.name == timeState, // 선택된 시간 상태 확인
                        onClick = {
                            onTimeSelected(if (time.name == timeState) "" else time.name)
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
                        isSelected = i == rateState, // 선택된 별점 상태 확인
                        onClick = {
                            onRateSelected(if (i == rateState) 0 else i)
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
                        isSelected = category.name == categoryState, // 선택된 카테고리 상태 확인
                        onClick = {
                            onCategorySelected(if (category.name == categoryState) "" else category.name)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        SmallButton(text = "Filter", buttonState = ButtonState.NORMAL)

        Spacer(modifier = Modifier.height(22.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterSearchBottomSheetPreview() {
    FilterSearchBottomSheet()
}

