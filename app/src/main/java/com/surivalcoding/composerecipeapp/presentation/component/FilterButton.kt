package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class SelectButton {

    @Composable
    fun FilterButton(
        text: String,
        isSelected: Boolean,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
            if (isSelected) Color.Blue else Color.White
            )
        ) {
            Text(text = text)
        }
    }

    @Composable
    fun RatingBar(
        rating: Int,
        onRatingChange: (Int) -> Unit
    ) {
        Row {
            repeat(5) { index ->
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    tint = if (index < rating) Color.Yellow else Color.Gray,

                )
            }
        }
    }

    @Composable
    fun MyScreen() {
        var selectedFilter by remember { mutableStateOf("") }
        var selectedRating by remember { mutableStateOf(0) }

        Column {
            FilterButton(
                text = "All",
                isSelected = selectedFilter == "All",
                onClick = { selectedFilter = "All" }
            )
            // ... other filter buttons

            RatingBar(
                rating = selectedRating,
                onRatingChange = { selectedRating = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    SelectButton().MyScreen()
}