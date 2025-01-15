package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.data.model.SearchRecipeItem
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.component.FoodImageBackground
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlin.math.round

@Composable
fun RecipeCard(
    searchRecipeItem: SearchRecipeItem,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.spare_ribs),
) {
    Card(
        modifier = modifier
            .aspectRatio(1f),
        shape = RoundedCornerShape(10.dp)
    ) {
        FoodImageBackground(
            imageUrl = searchRecipeItem.thumbnailUrl,
            placeholder = placeholder,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ReviewScore(
                rating = searchRecipeItem.rating,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = searchRecipeItem.title,
                    style = AppTextStyles.smallTextBold,
                    color = AppColors.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(3.dp))
                Text(
                    text = "by ${searchRecipeItem.authorName}",
                    style = AppTextStyles.smallerTextSmallLabel,
                    color = AppColors.Gray3,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun ReviewScore(
    rating: Double,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = AppColors.Secondary20,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Icon(
            imageVector = CraIcons.star,
            contentDescription = null,
            tint = AppColors.Rating,
            modifier = Modifier.width(10.dp)
        )
        Spacer(Modifier.width(3.dp))
        Text(
            text = "${round(rating * 10) / 10}",
            style = AppTextStyles.smallerTextSmallLabel
        )
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    val recipeItem = SearchRecipeItem(
        title = "Lamb chops with fruity couscous and mint\n\n",
        rating = 4.0,
        thumbnailUrl = "",
        authorName = "Spicy Nelly"
    )
    ComposeRecipeAppTheme {
        RecipeCard(
            modifier = Modifier.width(150.dp),
            searchRecipeItem = recipeItem,
            contentDescription = null
        )
    }
}