package com.surivalcoding.composerecipeapp.presentation.component

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
fun SquareRecipeCard(
    savedRecipe: SavedRecipe,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.spare_ribs),
) {
    RecipeCard(
        savedRecipe = savedRecipe,
        contentDescription = contentDescription,
        modifier = modifier.aspectRatio(1f),
        placeholder = placeholder,
    )
}

@Preview
@Composable
fun SquareRecipeCardPreview() {
    val savedRecipe = SavedRecipe(
        title = "Lamb chops with fruity couscous and mint\n\n",
        rating = 4.0,
        thumbnailUrl = "",
        authorName = "Spicy Nelly",
        cookingMinute = 20,
        isBookmarked = false
    )
    ComposeRecipeAppTheme {
        SquareRecipeCard(
            modifier = Modifier.width(150.dp),
            savedRecipe = savedRecipe,
            contentDescription = null
        )
    }
}