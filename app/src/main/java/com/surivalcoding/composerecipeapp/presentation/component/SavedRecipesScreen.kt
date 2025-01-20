package com.surivalcoding.composerecipeapp.presentation.component

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.viewModel.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SavedRecipesScreen(
    modifier: Modifier = Modifier,
    foodImage: List<String> = emptyList(),
    titles: List<String> = emptyList(),
    chefNames: List<String> = emptyList(),
    rates: List<Float> = emptyList(),
    cookingTimeMinutes: List<Int> = emptyList()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = AppColors.white
            )
            .padding(top = 54.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Saved recipes",
            style = AppTextStyles.mediumTextBold
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 15.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(titles.size) { index ->
                RecipeCard(
                    foodImage = foodImage[index],
                    title = titles[index],
                    chefName = chefNames[index],
                    rate = rates[index],
                    cookingTimeMinute = cookingTimeMinutes[index]
                )
            }
        }

    }
}

@Preview
@Composable
private fun SavedRecipesScreenPreview() {
    SavedRecipesScreen()
}