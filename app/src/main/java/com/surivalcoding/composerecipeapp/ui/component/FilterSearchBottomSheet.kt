package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.mock.fakeUserData
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.data.model.SearchFilterOptions
import com.surivalcoding.composerecipeapp.data.model.TimeType
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingFilterChip
import com.surivalcoding.composerecipeapp.ui.icon.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSearchBottomSheet(
    onDismissRequest: () -> Unit,
    filterOptions: SearchFilterOptions,
    onFilterClick: (SearchFilterOptions) -> Unit,
    modifier: Modifier = Modifier
) {
    var timeType by remember { mutableStateOf(filterOptions.time) }
    var rateScore by remember { mutableIntStateOf(filterOptions.rating) }
    var recipeCategoryType by remember { mutableStateOf(filterOptions.category) }


    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )


    ModalBottomSheet(
        containerColor = AppColors.White,
        modifier = modifier
            .fillMaxHeight(),
        sheetState = sheetState,
        dragHandle = null,
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 36.dp, start = 30.dp, end = 30.dp)
                .fillMaxHeight(0.9f),
        ) {
            Text(
                text = "Filter Search",
                style = AppTextStyles.smallTextSemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            TimeFilter(
                selected = timeType,
                onChipClick = {
                    timeType = it
                }
            )
            RateFilter(
                selected = rateScore,
                onChipClick = {
                    rateScore = it
                },
                modifier = Modifier.padding(vertical = 20.dp)
            )
            CategoryFilter(
                selected = recipeCategoryType,
                onChipClick = {
                    recipeCategoryType = it
                }
            )
            Spacer(Modifier.height(20.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SmallButton(
                    text = "Filter",
                    onClick = {
                        onFilterClick(
                            SearchFilterOptions(
                                timeType,
                                rateScore,
                                recipeCategoryType
                            )
                        )
                    },
                )
            }
        }
    }
}

@Composable
private fun TimeFilter(
    selected: TimeType,
    onChipClick: (TimeType) -> Unit,
    modifier: Modifier = Modifier,
) {
    ChipFilter(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        header = "Time",
        modifier = modifier
    ) {
        TimeType.entries.forEach {
            NoPaddingFilterChip(
                label = it.label,
                selectedColor = AppColors.Primary100,
                unSelectedColor = AppColors.Primary80,
                selected = selected == it,
                onClick = {
                    onChipClick(it)
                },
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 10.dp),
            )
        }
    }
}

@Composable
private fun RateFilter(
    selected: Int,
    onChipClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ChipFilter(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        header = "Rate",
        modifier = modifier
    ) {
        repeat(5) {
            val score = 5 - it
            NoPaddingFilterChip(
                label = "$score",
                selectedColor = AppColors.Primary100,
                unSelectedColor = AppColors.Primary80,
                selected = score == selected,
                onClick = {
                    onChipClick(score)
                },
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 10.dp),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = AppIcons.star,
                        tint = if (score == selected) AppColors.White else AppColors.Primary80,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Composable
private fun CategoryFilter(
    selected: RecipeCategory,
    onChipClick: (RecipeCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    ChipFilter(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        header = "Time",
        modifier = modifier
    ) {
        RecipeCategory.entries.forEach {
            NoPaddingFilterChip(
                label = it.label,
                selectedColor = AppColors.Primary100,
                unSelectedColor = AppColors.Primary80,
                selected = selected == it,
                onClick = {
                    onChipClick(it)
                },
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 10.dp),
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ChipFilter(
    header: String,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    modifier: Modifier = Modifier,
    items: @Composable RowScope.() -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = header,
            style = AppTextStyles.smallTextSemiBold,
            color = AppColors.Black,
        )
        Spacer(Modifier.height(10.dp))
        FlowRow(
            verticalArrangement = verticalArrangement,
            horizontalArrangement = horizontalArrangement,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterSearchBottomSheetPreview() {
    ComposeRecipeAppTheme {
        FilterSearchBottomSheet(
            onDismissRequest = {},
            filterOptions = fakeUserData.searchFilterOptions,
            onFilterClick = {}
        )
    }
}