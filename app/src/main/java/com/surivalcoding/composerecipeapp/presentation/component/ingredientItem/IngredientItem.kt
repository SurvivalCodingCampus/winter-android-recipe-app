package com.surivalcoding.composerecipeapp.presentation.component.ingredientItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.surivalcoding.composerecipeapp.presentation.component.button.BigButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun IngredientItem() {
    Box(
        modifier = Modifier
            .alpha(0.5f)
            .fillMaxWidth()
            .height(76.dp)
            .background(color = AppColors.Gray4, shape = RoundedCornerShape(size = 12.dp))
            .padding(start = 15.dp),

        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)
                    .background(color = AppColors.White, shape = RoundedCornerShape(size = 10.dp)),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__")
                        .crossfade(true)
                        .build(),
                    contentDescription = "ingredient picture",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 16.dp, right = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Tomatos",
                    style = AppTextStyles.boldNormal.copy(
                        color = Color(0xFF121212)
                    ),
                    modifier = Modifier
                )
                Text("500g", style = AppTextStyles.regularSmall)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem()
}
