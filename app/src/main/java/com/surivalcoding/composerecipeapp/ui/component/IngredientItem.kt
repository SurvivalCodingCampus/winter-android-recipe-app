package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.theme.Black
import com.surivalcoding.composerecipeapp.ui.theme.Gray3
import com.surivalcoding.composerecipeapp.ui.theme.Gray4
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography

@Composable
fun IngredientItem(
    imageUrl: String,
    title: String,
    weight: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = Gray4.copy(0.5f))
            .padding(15.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = if (LocalInspectionMode.current) {
                R.drawable.img_tomatoes
            } else {
                imageUrl
            },
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = PoppinsBoldTypography.bodyLarge,
                color = Black,
                maxLines = 1
            )
        }

        Text(
            text = weight,
            style = PoppinsRegularTypography.bodyMedium,
            color = Gray3,
            maxLines = 1
        )
    }
}

@Composable
fun IngredientItemExample() {
    IngredientItem(
        imageUrl = "https://avatars.githubusercontent.com/u/69616347?s=400&u=a21b6f668ded4ce82cb23a785f0ddc2a92abdd45&v=4",
        title = "Tomatoes",
        weight = "500g"
    )
}

@Preview(showBackground = true)
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        imageUrl = "https://avatars.githubusercontent.com/u/69616347?s=400&u=a21b6f668ded4ce82cb23a785f0ddc2a92abdd45&v=4",
        title = "Tomatoes",
        weight = "500g"
    )
}