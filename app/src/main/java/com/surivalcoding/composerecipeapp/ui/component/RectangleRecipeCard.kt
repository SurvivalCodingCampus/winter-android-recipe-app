package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun RectangleRecipeCard(
    savedRecipe: SavedRecipe,
    contentDescription: String?,
    isBookmarked: Boolean = false,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.traditional_spare_ribs_baked),
) {
    RecipeCard(
        thumbnailUrl = savedRecipe.thumbnailUrl,
        title = savedRecipe.title,
        rating = savedRecipe.rating,
        authorName = savedRecipe.authorName,
        cookingMinute = savedRecipe.cookingMinute,
        isBookmarked = isBookmarked,
        shouldShowRecipeMetadata = true,
        contentDescription = contentDescription,
        modifier = modifier.aspectRatio(2.1f),
        onCheckedChange = onCheckedChange,
        placeholder = placeholder,
    )
}

@Preview
@Composable
fun RectangleRecipeCardPreview() {
    val savedRecipe = SavedRecipe(
        id = 1,
        title = "Lamb chops with fruity couscous and mint\n\n",
        rating = 4.0,
        thumbnailUrl = "",
        authorName = "Spicy Nelly",
        cookingMinute = 20,
    )
    ComposeRecipeAppTheme {
        RectangleRecipeCard(
            modifier = Modifier.width(315.dp),
            savedRecipe = savedRecipe,
            contentDescription = null,
            onCheckedChange = {}
        )
    }
}