package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.item.RecipeList
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


// SavedRecipe 화면
@Composable
fun SavedRecipeScreen(
    state: SavedRecipeState,
    onAction: (SavedRecipeAction) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Saved recipes",
            style = AppTextStyles.mediumTextSemiBold.copy(
                color = AppColors.black,
                fontSize = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        RecipeList(state, onAction)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.loadingState.isLoading) {
            // 프로그래스바 적용
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = AppColors.primary_100
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedRecipeScreenPreview() {
    SavedRecipeScreen(
        state = SavedRecipeState(),
        onAction = {}
    )
}