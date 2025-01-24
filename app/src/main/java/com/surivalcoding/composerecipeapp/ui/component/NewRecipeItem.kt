package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.mock.fakeNewRecipes
import com.surivalcoding.composerecipeapp.data.model.NewRecipe
import com.surivalcoding.composerecipeapp.ui.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlin.math.roundToInt

@Composable
fun NewRecipeItem(
    newRecipe: NewRecipe,
    onClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick
            )
    ) {
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(
                containerColor = AppColors.White
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0xFF000000)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = newRecipe.title,
                    style = AppTextStyles.smallTextSemiBold,
                    color = AppColors.Gray1,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.width(140.dp)
                )
                Spacer(Modifier.height(10.dp))
                Row {
                    repeat(newRecipe.rating.roundToInt()) {
                        Icon(
                            imageVector = AppIcons.starRate,
                            contentDescription = "rate score",
                            tint = AppColors.Rating,
                            modifier = Modifier
                                .size(12.dp)
                                .offset(x = (-2).dp)
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(
                                onClick = onProfileClick
                            )
                    ) {
                        Image(
                            painter = painterResource(newRecipe.authorAvatarUrl),
                            contentDescription = "author avatar image",
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "By ${newRecipe.authorName}",
                            style = AppTextStyles.smallerTextRegular,
                            color = AppColors.Gray3,
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Icon(
                        painter = painterResource(AppIcons.alarm),
                        contentDescription = "cooking time icon",
                        tint = AppColors.Gray3,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "${newRecipe.cookingMinute} mins",
                        style = AppTextStyles.smallerTextRegular,
                        color = AppColors.Gray3
                    )
                }
            }
        }
        Image(
            painter = painterResource(newRecipe.foodIconUrl),
            contentDescription = "food image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(88.dp)
                .align(Alignment.TopEnd)
        )
    }
}


@Preview
@Composable
private fun NewRecipeItemPreview() {
    ComposeRecipeAppTheme {
        NewRecipeItem(
            newRecipe = fakeNewRecipes[0],
            onClick = {},
            onProfileClick = {},
            modifier = Modifier
                .width(252.dp)
                .height(128.dp)
        )
    }
}