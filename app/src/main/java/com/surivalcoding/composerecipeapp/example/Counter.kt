package com.surivalcoding.composerecipeapp.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade


@Composable
fun Counter(modifier: Modifier = Modifier) {

    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: ${count}",
            style = MaterialTheme.typography.headlineMedium
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://dimg.donga.com/wps/NEWS/IMAGE/2024/08/05/126340331.2.jpg")
                .crossfade(true)
                .build(),
            contentDescription = "",
            modifier = Modifier.clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { count++ }
        ) {
            Text("Increment")
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CounterPreview() {
    Counter()
}