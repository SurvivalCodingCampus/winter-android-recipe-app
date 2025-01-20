package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import IngredientDto
import Recipe
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.ingredientItem.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.SavedRecipesState
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SavedRecipesScreen(
    state: SavedRecipesState,
    onRecipeClick: (Recipe) -> Unit,
    onBookmarkClick: (Recipe) -> Unit,
) {
    val recipes =  state.recipes

    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text("Saved recipes", style = AppTextStyles.boldMedium)
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isLoading) {
                items(5) {
                    ShimmerRecipeCard()
                }

            }else {
                items(
                    count = recipes.size,
                    key = { index -> recipes[index].id },
                    contentType = { "recipe" }
                ) { index ->
                    RecipeCard(
                        recipe = recipes[index],
                        onClick = { onRecipeClick(recipes[index]) },
                        onClickBookmark = { onBookmarkClick(recipes[index]) },
                        modifier = Modifier,
                        isShowingDetail = true
                    )
                }

            }
        }
    }
}

@Composable
fun ShimmerRecipeCard() {
    var currentTranslation by remember { mutableStateOf(0f) }
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(currentTranslation - 500f, currentTranslation - 500f),
        end = Offset(currentTranslation, currentTranslation)
    )

    LaunchedEffect(translateAnim.value) {
        currentTranslation = translateAnim.value
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(brush)
            )

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(20.dp)
                        .background(brush)
                )
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(16.dp)
                        .background(brush)
                )
            }
        }
    }
}

@Preview
@Composable
fun SavedRecipesScreenPreview() {

    val recipe = Recipe(
        id = 30,
        name = "hh",
        time = "10",
        category = "Itailian",
        image = "http://",
        chef = "steve",
        rating = 3.0,
        ingredients = listOf<IngredientDto>(IngredientDto(1, "a", "b")),
    )

    val recipes = listOf(
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe,
        recipe
    )


    SavedRecipesScreen(
        state = SavedRecipesState(recipes),
        onRecipeClick = {},
        onBookmarkClick = {}
    )
}