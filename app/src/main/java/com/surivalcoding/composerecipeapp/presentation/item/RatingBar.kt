package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R


// input 값에 따라 별점을 표시하는 RatingBar

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    ratingCount: Int,
    maxRatingCount: Int = 5,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        for (i in 1..maxRatingCount) {
            AsyncImage(
                model = if (i <= ratingCount) R.drawable.star_fill else R.drawable.star_empty,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}

@Preview
@Composable
private fun RatingBarPreview() {
    RatingBar(
        maxRatingCount = 5,
        ratingCount = 3,
    )
}