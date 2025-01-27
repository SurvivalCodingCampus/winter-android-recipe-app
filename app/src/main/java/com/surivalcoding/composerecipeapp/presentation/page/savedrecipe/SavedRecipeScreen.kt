package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.RecipeList
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


// SavedRecipe 화면
@Composable
fun SavedRecipeScreen(viewModel: SavedRecipeViewModel = hiltViewModel()) {
    // collectAsStateWithLifecycle: composable함수로 flow에서 값을 수집하고 라이프사이클을 인식하여 최신값을 나타냄
    // 앱이 백그라운드에 있어 사용하지 않을 때 불필요한 리소스 낭비를 방지
    val bookMarkList by viewModel.bookMarkList.collectAsStateWithLifecycle()
    val loadingState by viewModel.loadingState.collectAsStateWithLifecycle()


    // 로티 애니메이션
    val lottieLoading by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animal))

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

        RecipeList(recipeList = bookMarkList.bookMarkList, viewModel = viewModel)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (loadingState.isLoading) {
            // 로티 애니메이션 로딩
            LottieAnimation(
                composition = lottieLoading,
                modifier = Modifier
                    .size(400.dp)
                    .align(Alignment.Center)
            )
        }
    }
}