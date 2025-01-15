package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.model.Ingredient
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

private val IMAGE_SIZE = 52.dp
private val SPACING = 15.dp
private val CARD_VERTICAL_PADDING = 12.dp
private val CARD_HORIZONTAL_PADDING = 16.dp
private val CARD_ROUNDNESS = 12.dp
private val IMAGE_ROUNDNESS = 10.dp
private val TITLE_TEXT_STYLE = AppTextStyles.kS16LH24.copy(fontWeight = FontWeight.W600)
private val TRAILING_TEXT_STYLE = AppTextStyles.kS16LH24.copy(color = AppColors.textGrey)
private val DEFAULT_IMAGE_MODIFIER =
    Modifier
        .size(IMAGE_SIZE)
        .background(AppColors.withe, RoundedCornerShape(IMAGE_ROUNDNESS))
private val DEFAULT_CARD_MODIFIER = Modifier
    .background(AppColors.cardBackground, RoundedCornerShape(CARD_ROUNDNESS))
    .padding(vertical = CARD_VERTICAL_PADDING, horizontal = CARD_HORIZONTAL_PADDING)
    .fillMaxWidth()

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = DEFAULT_IMAGE_MODIFIER,
    titleTextStyle: TextStyle = TITLE_TEXT_STYLE,
    trailingTextStyle: TextStyle = TRAILING_TEXT_STYLE,
    ingredient: Ingredient,
) {
    Box(
        DEFAULT_CARD_MODIFIER.then(modifier)
    ) {
        Row(
            verticalAlignment = CenterVertically,
        ) {
            AsyncImage(
                model = ingredient.imageUrl,
                contentDescription = ingredient.name,
                contentScale = ContentScale.Crop,
                modifier = DEFAULT_IMAGE_MODIFIER.then(imageModifier)
            )
            Spacer(
                modifier = Modifier.width(SPACING),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Text(
                    ingredient.name,
                    modifier = Modifier.weight(1f),
                    style = titleTextStyle
                )
                Text("${ingredient.amount}g", style = trailingTextStyle)

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient.default()
    )
}
