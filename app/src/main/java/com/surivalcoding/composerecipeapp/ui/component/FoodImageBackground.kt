package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R

@Composable
fun FoodImageBackground(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(10.dp),
    placeholder: Painter = painterResource(R.drawable.placeholder_defalut),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
    ) {
        DynamicAsyncImage(
            imageUrl = imageUrl,
            placeholder = placeholder,
            contentDescription = contentDescription,
            modifier = Modifier.matchParentSize()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(contentPadding)
        ) {
            content()
        }
    }
}