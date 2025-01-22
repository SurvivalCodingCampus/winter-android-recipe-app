package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.mock.fakeSavedRecipe
import com.surivalcoding.composerecipeapp.ui.AppIcons
import com.surivalcoding.composerecipeapp.ui.custom.FoodImageBackground
import com.surivalcoding.composerecipeapp.ui.custom.HoIconToggleButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlin.math.round

@Composable
fun RecipeCard(
    thumbnailUrl: String,
    title: String,
    rating: Double,
    authorName: String,
    cookingMinute: Int = 0,
    isBookmarked: Boolean = false,
    contentDescription: String?,
    onCheckedChange: () -> Unit = {},
    shouldShowRecipeMetadata: Boolean = false,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.traditional_spare_ribs_baked),
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        FoodImageBackground(
            imageUrl = thumbnailUrl,
            placeholder = placeholder,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ReviewScore(
                rating = rating,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(
                        if (shouldShowRecipeMetadata) 0.5f else 1f
                    )
                ) {
                    Text(
                        text = title,
                        style = AppTextStyles.smallTextBold,
                        color = AppColors.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(3.dp))
                    Text(
                        text = "By $authorName",
                        style = AppTextStyles.smallerTextSmallLabel.copy(
                            fontSize = 8.sp
                        ),
                        color = AppColors.Gray3,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (shouldShowRecipeMetadata) {
                    RecipeMetaData(
                        isBookmarked = isBookmarked,
                        onCheckedChange = onCheckedChange,
                        cookingMinute = cookingMinute
                    )
                }
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
            imageVector = AppIcons.star,
            contentDescription = null,
            tint = AppColors.Rating,
            modifier = Modifier.width(10.dp)
        )
        Spacer(Modifier.width(3.dp))
        Text(
            text = "${round(rating * 10) / 10}",
            style = AppTextStyles.smallerTextSmallLabel,
            color = AppColors.Black
        )
    }
}

@Composable
private fun RecipeMetaData(
    isBookmarked: Boolean,
    onCheckedChange: () -> Unit,
    cookingMinute: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = AppIcons.alarm,
            contentDescription = null,
            tint = AppColors.Gray4
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = "$cookingMinute min",
            style = AppTextStyles.smallerTextRegular,
            color = AppColors.Gray4,
        )
        Spacer(Modifier.width(10.dp))
        HoIconToggleButton(
            modifier = Modifier.size(24.dp),
            onCheckedChange = onCheckedChange,
            checked = isBookmarked,
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.outlinedBookMark),
                    contentDescription = null
                )
            },
            checkedIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.outlinedBookMark),
                    contentDescription = null
                )
            },
        )
    }
}

@Preview
@Composable
private fun RecipeCardPreview() {
    ComposeRecipeAppTheme {
        RecipeCard(
            thumbnailUrl = fakeSavedRecipe[0].thumbnailUrl,
            title = fakeSavedRecipe[0].title,
            rating = fakeSavedRecipe[0].rating,
            authorName = fakeSavedRecipe[0].authorName,
            cookingMinute = fakeSavedRecipe[0].cookingMinute,
            isBookmarked = false,
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f)
        )
    }
}