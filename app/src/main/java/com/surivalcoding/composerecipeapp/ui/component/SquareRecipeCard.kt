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
import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SquareRecipeCard(
    searchRecipe: SearchRecipe,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.spare_ribs),
) {
    RecipeCard(
        thumbnailUrl = searchRecipe.thumbnailUrl,
        title = searchRecipe.title,
        rating = searchRecipe.rating,
        authorName = searchRecipe.authorName,
        contentDescription = contentDescription,
        modifier = modifier.aspectRatio(1f),
        placeholder = placeholder,
    )
}

@Preview
@Composable
fun SquareRecipeCardPreview() {
    ComposeRecipeAppTheme {
        SquareRecipeCard(
            searchRecipe = fakeSearchRecipe[0],
            modifier = Modifier.width(150.dp),
            contentDescription = null
        )
    }
}