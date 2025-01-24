package com.surivalcoding.composerecipeapp.presentation.component.filter_bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.domain.model.enums.Categories
import com.surivalcoding.composerecipeapp.domain.model.enums.TimeFilter
import com.surivalcoding.composerecipeapp.presentation.component.FilterChip
import com.surivalcoding.composerecipeapp.presentation.component.SmallButton
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterBottomSheet(
    state: FilterState,
    onTimeFilterChange: (TimeFilter) -> Unit,
    onRateFilterChange: (Int?) -> Unit,
    onCategoryFilterChange: (String?) -> Unit,
    onFilterApply: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Filter Search",
            style = AppTextStyles.mediumTextBold,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        FilterSection("Time") {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TimeFilter.entries.forEach { timeFilter ->
                    FilterChip(
                        text = timeFilter.label,
                        isSelected = state.timeFilter == timeFilter,
                        onSelectionChange = { onTimeFilterChange(timeFilter) }
                    )
                }
            }
        }

        FilterSection("Rate") {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                (1..5).reversed().forEach { rate ->
                    FilterChip(
                        text = rate.toString(),
                        showStar = true,
                        isSelected = state.rateFilter == rate,
                        onSelectionChange = {
                            onRateFilterChange(if (state.rateFilter == rate) null else rate)
                        }
                    )
                }
            }
        }

        FilterSection("Category") {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Categories.entries.forEach { category ->
                    FilterChip(
                        text = category.label,
                        showStar = category == Categories.DINNER,
                        isSelected = state.categoryFilter == category.label,
                        onSelectionChange = {
                            onCategoryFilterChange(
                                if (state.categoryFilter == category.label) null
                                else category.label
                            )
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        SmallButton(
            buttonText = "Filter",
            onClick = onFilterApply,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun FilterSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = title,
            style = AppTextStyles.smallTextBold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterBottomSheetPreview() {
    FilterBottomSheet(state = FilterState(), onTimeFilterChange = {}, onRateFilterChange = {}, onCategoryFilterChange = {}, onFilterApply = {})
}