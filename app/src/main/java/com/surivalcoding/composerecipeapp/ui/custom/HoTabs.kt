package com.surivalcoding.composerecipeapp.ui.custom

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun HoTabRow(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.onPrimary,
    tabs: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = containerColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        tabs()
    }
}

@Composable
fun RowScope.HoTab(
    label: String,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
    selectedLabelColor: Color = MaterialTheme.colorScheme.onPrimary,
    unselectedLabelColor: Color = MaterialTheme.colorScheme.primary,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    val contentColor = if (selected) {
        selectedLabelColor
    } else {
        unselectedLabelColor
    }

    val backgroundColor by animateColorAsState(
        targetValue = if (selected) unselectedLabelColor else Color.Transparent,
        animationSpec = tween(durationMillis = 300),
        label = ""
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .weight(1f)
            .fillMaxHeight()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick)
            .semantics { this.selected = selected }
    ) {
        Text(
            text = label,
            style = textStyle,
            color = contentColor
        )
    }
}


@Preview
@Composable
fun TabsPreview() {
    ComposeRecipeAppTheme {
        val titles = listOf("Topics", "People", "banana")
        HoTabRow(
            modifier = Modifier.height(58.dp)
        ) {
            titles.forEachIndexed { index, title ->
                HoTab(
                    selected = index == 0,
                    onClick = { },
                    label = title,
                )
            }
        }
    }
}