package com.surivalcoding.composerecipeapp.presentation.component

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun RowScope.CraTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
) {
    val contentColor = if (selected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.primary
    }

    val backgroundColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.primary else Color.Transparent,
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
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = contentColor
        )
    }
}


@Composable
fun CraTabRow(
    modifier: Modifier = Modifier,
    tabs: @Composable RowScope.() -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        tabs()
    }
}


@Preview
@Composable
fun TabsPreview() {
    ComposeRecipeAppTheme {
        val titles = listOf("Topics", "People", "banana")
        CraTabRow {
            titles.forEachIndexed { index, title ->
                CraTab(
                    selected = index == 0,
                    onClick = { },
                    title = title,
                )
            }
        }
    }
}