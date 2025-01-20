package com.surivalcoding.composerecipeapp.example.numbercorrect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
* 숫자 맞추기 게임
* */



@Composable
fun NumberGuessScreen(
    modifier: Modifier = Modifier,
    state: NumberGuessState = NumberGuessState(),
    onValueChange: (String) -> Unit = {},
    onGuessClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            Alignment.CenterVertically
        )
    ) {
        TextField(
            value = state.numberText,
            onValueChange = { newText ->
                onValueChange(newText)
            }
        )

        Button(onClick = { onGuessClick() }) {
            Text("맞추기")
        }
        Text(state.guessText ?: "")
    }
}


@Preview(showBackground = true)
@Composable
fun NumberGuessScreenPreview(modifier: Modifier = Modifier) {
    NumberGuessScreen(
        state = NumberGuessState(
            numberText = "1234",
            guessText = "Up",
            isCorrect = false
        )
    )
}
