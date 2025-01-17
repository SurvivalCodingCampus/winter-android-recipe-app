package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.component.Recipe
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SavedRecipesScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Saved recipes",
            style = AppTextStyles.normalTextBold.copy(
                fontSize = 18.sp,
                color = AppColors.font
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(count = 10) {
                RecipeCard(
                    recipe = Recipe(
                        id = "1",
                        name = "JMT Egg",
                        authorName = "Rami",
                        timeTaken = 10,
                        rate = 5.0f,
                        circledThumbnailImageUrl = "",
                        thumbnailImageUrl = "https://png.pngtree.com/png-vector/20231016/ourlarge/pngtree-breakfast-fried-egg-png-image_10198332.png",
                        isUserSaved = false,
                        isUserReviewed = false,
                        isUserRated = true,
                        isNew = false,
                        categories = listOf("Italian", "Pasta"),
                        createdAt = LocalDateTime.now()
                    )
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun SavedRecipesScreenPreview() {
    SavedRecipesScreen(modifier = Modifier)
}