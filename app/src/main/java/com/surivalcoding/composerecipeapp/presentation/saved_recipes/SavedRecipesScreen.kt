package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import AppColors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SavedRecipesScreen(
    state: SavedRecipesState = SavedRecipesState(),
    modifier: Modifier = Modifier,
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            "Saved recipes",
            style = AppTextStyles.normalTextBold.copy(
                fontSize = 18.sp,
                color = AppColors.font
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        if (state.isLoading) {
            // 로딩 UI
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = AppColors.primary100,
                    modifier = Modifier.size(100.dp)
                )
            }
        } else {
            LazyColumn(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(state.recipes) {
                    RecipeCard(
                        recipe = it
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun SavedRecipesScreenPreview() {
    SavedRecipesScreen(modifier = Modifier)

}