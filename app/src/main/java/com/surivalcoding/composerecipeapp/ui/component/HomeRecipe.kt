package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.mock.fakeHomeRecipes
import com.surivalcoding.composerecipeapp.data.model.HomeRecipe
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.icon.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun HomeRecipeItem(
    homeRecipe: HomeRecipe,
    isBookmarked: Boolean,
    onClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
                .background(
                    color = AppColors.Gray4.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(10.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = homeRecipe.title,
                style = AppTextStyles.smallTextSemiBold,
                color = AppColors.Gray1,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Time",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.Gray3,
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "${homeRecipe.cookingMinute} Mins",
                    style = AppTextStyles.smallerTextSemiBold,
                    color = AppColors.Gray1
                )
            }
            NoPaddingButton(
                onClick = onBookmarkClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isBookmarked) AppColors.Primary80 else AppColors.Gray3,
                    containerColor = AppColors.White
                ),
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.outlinedBookMark),
                    contentDescription = "check bookmark",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(16.dp)
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(homeRecipe.foodIconUrl),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.Center)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .background(
                        color = AppColors.Secondary20,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(vertical = 3.dp, horizontal = 7.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = AppIcons.starRate,
                    contentDescription = "rate score",
                    tint = AppColors.Rating,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "${homeRecipe.rating}",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.Black
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeRecipePreview() {
    ComposeRecipeAppTheme {
        HomeRecipeItem(
            homeRecipe = fakeHomeRecipes[0],
            isBookmarked = true,
            onClick = {},
            onBookmarkClick = {},
            modifier = Modifier
                .width(150.dp)
                .height(232.dp)
        )
    }
}
