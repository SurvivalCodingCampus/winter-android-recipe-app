package com.surivalcoding.composerecipeapp.presentation.component.ingredientItem

import IngredientDto
import Recipe
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipSearchGrid(
    recipes: List<Recipe>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(bottom = 20.dp)
        ,
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true,
        content = {
            items(
                recipes.size
            ) { index ->
                RecipeSearchCard(recipe = recipes[index], onClick = {})
            }
        }
    )
}


@Composable
fun RecipeSearchCard(
    recipe: Recipe,
    onClick: () -> Unit = {},
) {
    val brush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent, Color.Black.copy(alpha = 0.8f)
        ), startY = 0f, endY = 800f
    )

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = AppColors.Black, shape = RoundedCornerShape(size = 10.dp))
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.TopStart,
    ) {
        Box(modifier = Modifier.drawWithContent {
            drawContent()
            drawRect(brush = brush)
        }) {
            AsyncImage(
                model = if (LocalInspectionMode.current) {
                    R.drawable.ic_launcher_background
                } else {
                    recipe.image
                },
                contentDescription = "ingredient picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(size = 10.dp))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp, top = 10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier
                    .width(37.dp)
                    .height(16.dp)
                    .background(
                        color = Color(0xFFFFE1B3), shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "star",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(size = 10.dp))
                        .size(8.dp)

                )
                Text(
                    text = recipe.rating.toString(), style = AppTextStyles.regularSmaller.copy(
                        fontSize = 8.sp
                    )
                )

            }



            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                Box(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Box(
                            modifier = Modifier
                                .height(42.dp)
                                .width((200.dp)),
                            contentAlignment = Alignment.BottomStart

                        ) {
                            Text(
                                recipe.name, style = AppTextStyles.boldSmall.copy(
                                    color = AppColors.White,
                                    lineHeightStyle = AppTextStyles.boldSmall.lineHeightStyle,
                                    lineHeight = AppTextStyles.boldSmall.lineHeight

                                )
                            )

                        }
                        Text(
                            "By Chef ${recipe.chef}", style = AppTextStyles.regularTiny.copy(
                                color = AppColors.LabelWhite,
                            )
                        )
                    }
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun RecipeSearchCardPreview() {
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

    val recipes = listOf(recipe, recipe, recipe)


    RecipSearchGrid(recipes)
}
