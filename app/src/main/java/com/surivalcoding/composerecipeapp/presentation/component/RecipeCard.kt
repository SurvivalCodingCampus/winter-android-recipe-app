package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add

import androidx.compose.material.icons.outlined.DateRange

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class Recipe(
    val title: String,
    val creator: String,
    val imageUrl: String,
    val rating: Float,
    val cookingTime: Int,
    val isBookmarked: Boolean = false
)

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val (image, title, creator, timeIcon, time, ratingIcon, rating, bookmark) = createRefs()

        AsyncImage(
            model = recipe.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = recipe.title,
            style = AppTextStyles.normalTextBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.constrainAs(title) {
                bottom.linkTo(creator.top, margin = 4.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "By ${recipe.creator}",
            style = AppTextStyles.smallTextRegular,
            modifier = Modifier.constrainAs(creator) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Icon(
            imageVector = Icons.Outlined.DateRange,
            contentDescription = null,
            modifier = Modifier.constrainAs(timeIcon) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(creator.end, margin = 16.dp)
            }
        )

        Text(
            text = "${recipe.cookingTime} min",
            style = AppTextStyles.smallTextRegular,
            modifier = Modifier.constrainAs(time) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(timeIcon.end, margin = 4.dp)
            }
        )

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = AppColors.secondary100,
            modifier = Modifier.constrainAs(ratingIcon) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(rating.start, margin = 4.dp)
            }
        )

        Text(
            text = "${recipe.rating}",
            style = AppTextStyles.smallTextRegular,
            modifier = Modifier.constrainAs(rating) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )

        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = null,
            modifier = Modifier.constrainAs(bookmark) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe(
            title = "Spicy fried rice mix chicken bali",
            creator = "Spicy Nelly",
            imageUrl = "https://example.com/image.jpg",
            rating = 4.0f,
            cookingTime = 20
        )
    )
}