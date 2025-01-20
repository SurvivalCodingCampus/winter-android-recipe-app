package com.surivalcoding.composerecipeapp.presentation.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.data.viewmodel.RecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.RecipeList
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


// SavedRecipe 화면
@Composable
fun SavedRecipeScreen(viewModel: RecipeViewModel) {
    // collectAsStateWithLifecycle: composable함수로 flow에서 값을 수집하고 라이프사이클을 인식하여 최신값을 나타냄
    // 앱이 백그라운드에 있어 사용하지 않을 때 불필요한 리소스 낭비를 방지
    val recipeList by viewModel.recipeList.collectAsStateWithLifecycle()

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

        RecipeList(recipeList)
    }
}